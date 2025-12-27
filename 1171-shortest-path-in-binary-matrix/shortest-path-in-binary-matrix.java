class Pair{
    int x;
    int y;
    int dist;

    Pair(int x, int y, int dist){
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}
class Solution {
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int vis[][] = new int[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                vis[i][j] = Integer.MAX_VALUE;
            }
        }
        vis[0][0] = 0;

        int delR[] = {0, 1, 1, 1, 0, -1, -1, -1};
        int delC[] = {1, 1, 0, -1, -1, -1, 0, 1};

        Queue<Pair> q = new LinkedList<>();
        // if starting cell is itself 1, then we cant move further, and simply return -1.
        if(grid[0][0] == 1){
            return -1;
        }

        // if single element, then always possible.
        if(n == 1) return 1;
        q.add(new Pair(0, 0, 1));

        while(!q.isEmpty()){
            Pair curr = q.remove();
            int row = curr.x;
            int col = curr.y;
            int distance = curr.dist;

            for(int i = 0; i < 8; i++){
                int newR = row + delR[i];
                int newC = col + delC[i];

                if(newR >= 0 && newR < n && newC >= 0 && newC < n && grid[newR][newC] == 0
                    && distance + 1 < vis[newR][newC])
                {
                    vis[newR][newC] = distance + 1;

                    if(newR == n-1 && newC == n-1){
                        return distance + 1;
                    }

                    q.add(new Pair(newR, newC, distance+1));
                }
            }
        }
        return -1;
        
    }
}