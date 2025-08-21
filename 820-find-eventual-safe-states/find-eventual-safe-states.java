class Solution {

    // Intuition : Since we know that terminal node will not be having outgoing edges, it can have only incoing edges.
    // So if somehow are can find out the total number of nodes whose destination is these terminal nodes.

    // So simply applying the DFS(Detecting the cycle). 

    // We know that any node which is in the cycle or leading to the cycle, will not be the safe nodes, because it has some paths which is not ending at the terminal node.
    // so all the nodes, which is in the cycle or leading to the cycle, will not be safe nodes, remaining nodes will be the safe nodes.


    private boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean vis[], boolean pathVis[], boolean check[]){

        vis[node] = true;
        pathVis[node] = true;

        check[node] = false; // till all the dfs call of current node is not completed, till then we can not
        // say that either the current node is safe node or not.

        for(int nbr : adj.get(node)){
            if(!vis[nbr]){
                if(dfs(nbr, adj, vis, pathVis, check) == true){
                    // If dfs is returning true, that means is this node is part of cycle, so it can't be the safe nodes.
                    check[nbr] = false;
                    return true;
                }
            }

            else if(pathVis[nbr] == true){
                // if we got the cycle, that means current node is not safe node,
                check[nbr] = false;
                return true;
            }
        }

        // If all the dfs call of current node has been completed, that means we have got a node, who is somehow reaching to the
        // terminal, so marking it as safe node.
        check[node] = true;

        // make the path as unvisited when going back from after completing any dfs call.
        pathVis[node] = false;

        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
       
        int V = graph.length;

        //  the Adjacency list.
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        

        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < V; i++){
           
            for(int j = 0; j < graph[i].length; j++){
               
                adj.get(i).add(graph[i][j]);
            }
           
        }

        boolean vis[] = new boolean[V];
        boolean pathVis[] = new boolean[V];

        boolean check[] = new boolean[V];

        for(int i = 0; i < V; i++){
            if(!vis[i]){
                dfs(i, adj, vis, pathVis, check);
            }
        }

        List<Integer> safeNodes = new ArrayList<>();
        for(int i = 0; i < V; i++){
            if(check[i] == true){
                safeNodes.add(i);
            }
        }

        Collections.sort(safeNodes);

        return safeNodes;
        
        
    }
}