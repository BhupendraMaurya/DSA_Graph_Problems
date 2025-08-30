class Pair{
    int distance;
    int row;
    int col;

    Pair(int distance, int row, int col){
        this.distance = distance;
        this.row = row;
        this.col = col;  
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {
        // Min Heap(Minimum element would be in the top).
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y) -> x.distance - y.distance);

        int n = heights.length;
        int m = heights[0].length;

        int dist[][] = new int[n][m];
        for(int rows[] : dist){
            Arrays.fill(rows, Integer.MAX_VALUE);
        }
        // initialising the distance of source from source as zero.
        dist[0][0] = 0;
        pq.add(new Pair(0,0,0));
        // Making the two arrays to traverse on the four directions on each cell.
        int delR[] = {-1, 0, 1, 0};
        int delC[] = {0, 1, 0, -1};

        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            int diff = curr.distance;
            int row = curr.row;
            int col = curr.col;

            //if you have reached at the destination, then just return the difference.
            if(row == n-1 && col == m-1){
                return diff;
            }

            // Traversing on all the four direction of current node.
            for(int i = 0; i < 4; i++){
                int nr = row + delR[i];
                int nc = col + delC[i];

                if(nr >= 0 && nr < n && nc >= 0 && nc < m){
                    int newEffort = Math.max(Math.abs(heights[row][col] - heights[nr][nc]), diff);
                    if(newEffort < dist[nr][nc]){
                        dist[nr][nc] = newEffort;
                        pq.add(new Pair(newEffort, nr, nc));
                    }
                }
            }   
        }

        return 0;
    }
}