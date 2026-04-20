import java.util.*;

class Pair {
    int row, col, time, color;

    Pair(int r, int c, int t, int clr) {
        row = r;
        col = c;
        time = t;
        color = clr;
    }
}

class Solution {

    public int[][] colorGrid(int n, int m, int[][] sources) {

        int[][] color = new int[n][m];
        int[][] time = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(time[i], Integer.MAX_VALUE);
        }

        // PQ: first by time, then by color (max color first)
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a.time != b.time) return a.time - b.time;
                return b.color - a.color; // max color first
            }
        );

        // add all sources
        for (int[] src : sources) {
            int r = src[0], c = src[1], clr = src[2];
            pq.add(new Pair(r, c, 0, clr));
            time[r][c] = 0;
            color[r][c] = clr;
        }

        int[] delR = {-1, 0, 1, 0};
        int[] delC = {0, 1, 0, -1};

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();

            int r = curr.row;
            int c = curr.col;
            int tm = curr.time;
            int clr = curr.color;

            for (int i = 0; i < 4; i++) {
                int nr = r + delR[i];
                int nc = c + delC[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {

                    if (time[nr][nc] > tm + 1) {
                        time[nr][nc] = tm + 1;
                        color[nr][nc] = clr;
                        pq.add(new Pair(nr, nc, tm + 1, clr));
                    }
                    else if (time[nr][nc] == tm + 1) {
                        // same time → take max color
                        if (clr > color[nr][nc]) {
                            color[nr][nc] = clr;
                        }
                    }
                }
            }
        }

        return color;
    }
}