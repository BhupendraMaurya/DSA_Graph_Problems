class Solution {

    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    static class Info {
        int v;
        int cost;
        int stops;

        public Info(int v, int c, int s) {
            this.v = v;
            this.cost = c;
            this.stops = s;
        }
    }

    private void createGraph(int[][] flights, ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] flight : flights) {
            int src = flight[0];
            int dest = flight[1];
            int wt = flight[2];
            graph[src].add(new Edge(src, dest, wt));
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Step 1: Build graph
        ArrayList<Edge>[] graph = new ArrayList[n];
        createGraph(flights, graph);

        // Step 2: Initialize distance array
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Step 3: BFS Queue
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));

        // Step 4: BFS Traversal with stops check
        while (!q.isEmpty()) {
            Info curr = q.remove();

            for (int i = 0; i < graph[curr.v].size(); i++) {
                Edge e = graph[curr.v].get(i);
                int v = e.dest;
                int wt = e.wt;

                // ✅ main relaxation condition with stops check
                if (curr.cost + wt < dist[v] && curr.stops <= k) {
                    dist[v] = curr.cost + wt;
                    q.add(new Info(v, dist[v], curr.stops + 1));
                }
            }
        }

        // Step 5: Return result
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}