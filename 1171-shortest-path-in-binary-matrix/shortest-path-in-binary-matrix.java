class Solution {
    static class Pair {
        int x;
        int y;
        int length;

        Pair(int x, int y, int length){
            this.x = x;
            this.y = y;
            this.length = length;
        }

       
    }
    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;

        if(grid[0][0] == 1 || grid[n-1][n-1] == 1){
            return -1;
        }
        
        // We were using the PW because we wanted the smallest length of different lengths, but here, every length of each cell would be increased buy 
        // 1 only, so we do not require PQ. as it will increase the TC.
        Queue<Pair> q = new LinkedList<>();
        int delR[] = {0, 1, 1, 1, 0, -1, -1, -1};
        int delC[] = {1, 1, 0, -1, -1, -1, 0, 1};

        boolean vis[][] = new boolean[n][n];

        int length = 1;

        // adding the src in the pq and length as 1 in the starting.
        q.add(new Pair(0,0, length));
        vis[0][0] = true;

        while(!q.isEmpty()){
            Pair curr = q.remove();
            int u = curr.x;
            int v = curr.y;
            int currLen = curr.length;

            // if current index is the last indx(means last cell), then just return the length.
            if(u == n-1 && v == n-1){
                return currLen;
            }

            
                // Traversing in all the 8 directions. of current cell.
            for(int i = 0; i < 8; i++){
                int nr = u + delR[i];
                int nc = v + delC[i];

                if(nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 0 && !vis[nr][nc]){
                    q.add(new Pair(nr, nc, currLen+1));
                    vis[nr][nc] = true;
                }
            }
            
        }

        return -1;

    }
}