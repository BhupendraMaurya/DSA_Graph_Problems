class Solution {

    // Intuition:  bacically checking for : Check for cycle in directed cyclic graph. if having cycle, then
    // topo sort not possible, so return false, else true.: using DFS.


    // checking that where given graph is having the cycle or not.
    private boolean dfs(int node, boolean vis[], boolean pathVis[], ArrayList<ArrayList<Integer>> adj){

        vis[node] = true;
        pathVis[node] = true;

        for(int nbr : adj.get(node)){
            if(!vis[nbr]){
                if(dfs(nbr, vis, pathVis, adj) == true){
                    return true;
                }
            }

            else if(pathVis[nbr] == true){
                return true;
            }
        }

        /// while backtracking mark the path as unvisited, because, you are going back from the current path
        pathVis[node] = false;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        int V = numCourses;
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }

        for(int edge[] : prerequisites ){
            int u = edge[0];
            int v = edge[1];
// here we are adding reverse because the question is saying that for the pair : [0, 1], it indicates that
// to take course 0, you have to take the course 1.

// Means basically, we can reverse the edges while adding in adj list and then we can apply the 
// same logic of Topo sort for this list, and it will work absolutely fine.
            adj.get(v).add(u);
        }

        // using the DFS, we can simply check that if there is a cycle in this graph, if yes,
        // then we can not finish all the courses, and if there is no cycle, then return 
        // as we can complete the course, so true.

        boolean vis[] = new boolean[V];
        boolean pathVis[] = new boolean[V];

        for(int i = 0; i < V; i++){
            if(!vis[i]){

                // if at any moment we found that graph has the cycle, that means topo sort is not possible
                // so return false in final answer.
                if(dfs(i, vis, pathVis, adj) == true){
                    return false;
                }
            }
        }

        // if there is not any cycle in the given graph, then return true.
        return true;

        
    }
}