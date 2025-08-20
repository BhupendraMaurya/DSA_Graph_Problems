class Solution {

    // Intuition : Since we know that terminal node will not be having outgoing edges, it can have only incoing edges.
    // So if somehow are can find out the total number of nodes whose destination is these terminal nodes.

    // So simply applying the DFS(Detecting the cycle). 

    // We know that any node which is in the cycle or leading to the cycle, will not be the safe nodes, because it has some paths which is not ending at the terminal node.
    // so all the nodes, which is in the cycle or leading to the cycle, will not be safe nodes, remaining nodes will be the safe nodes.


    private boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean vis[], boolean pathVis[], boolean check[]){

        vis[node] = true;
        pathVis[node] = true;

        check[node] = false; // means we are not sure that whethere we are in the cycle or not, that is why we are marking it as false
        // means currently this node is not safe node.

        for(int nbr : adj.get(node)){

            if(!vis[nbr]){
                if(dfs(nbr, adj, vis, pathVis, check) == true){
                    return true;
                }
            }

            else if(pathVis[nbr] == true){
                return true;
            }
        }

        // if all the dfs for current node has been completed, and we did not get any cycle, then we can say that yes
        // it is our safe node, so make the check for current node as true.
        check[node] = true;
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