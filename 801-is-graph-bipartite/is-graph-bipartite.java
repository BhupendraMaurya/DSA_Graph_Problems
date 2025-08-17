class Solution {
    
    private boolean dfs(int currNode, int color[], int graph[][], int col){
        
        color[currNode] = col;
        
        for(int nbr : graph[currNode]){
            if(color[nbr] == -1){
                
                if(dfs(nbr, color, graph, 1 - col) == false){
                    return false;
                }
            }

            else if(color[nbr] == col){
                return false;
            }
        }

        return true;
    }
    public boolean isBipartite(int[][] graph) {
        
        int n = graph.length;

        int color[] = new int[n];

        Arrays.fill(color, -1);

        for(int i = 0; i < n; i++){
            if(color[i] == -1 && dfs(i, color, graph, 0) == false){
                return false;
            }
        }

        return true;
    }
}