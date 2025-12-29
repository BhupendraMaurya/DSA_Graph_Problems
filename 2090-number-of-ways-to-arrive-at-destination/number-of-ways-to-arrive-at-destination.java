class Edges implements Comparable<Edges> {
    int node;
    long wt;

    Edges(int node, long wt) {
        this.node = node;
        this.wt = wt;
    }

    @Override
    public int compareTo(Edges e) {
        return Long.compare(this.wt, e.wt);
    }
}

class Solution {
    static final int MOD = 1_000_000_007;

    public int countPaths(int n, int[][] roads) {

        ArrayList<ArrayList<Edges>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] r : roads) {
            adj.get(r[0]).add(new Edges(r[1], r[2]));
            adj.get(r[1]).add(new Edges(r[0], r[2]));
        }

        long[] dist = new long[n];
        int[] ways = new int[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        dist[0] = 0;
        ways[0] = 1;

        PriorityQueue<Edges> pq = new PriorityQueue<>();
        pq.add(new Edges(0, 0));

        while (!pq.isEmpty()) {
            Edges curr = pq.poll();
            int node = curr.node;
            long wt = curr.wt;

            if (wt > dist[node]) continue;

            for (Edges nbr : adj.get(node)) {
                int newNode = nbr.node;
                long newWt = nbr.wt;

                if (dist[node] + newWt < dist[newNode]) {
                    dist[newNode] = dist[node] + newWt;
                    ways[newNode] = ways[node];
                    pq.add(new Edges(newNode, dist[newNode]));
                }
                else if (dist[node] + newWt == dist[newNode]) {
                    ways[newNode] = (ways[newNode] + ways[node]) % MOD;
                }
            }
        }

        return ways[n - 1];
    }
}
