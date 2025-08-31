class Solution {

    static class Pair implements Comparable<Pair>{
        int node;
        int time;

        Pair(int node, int time){
            this.node = node;
            this.time = time;
        }

        public int compareTo(Pair p){
            return this.time - p.time;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }

        for(int edge[] : times){
            int u = edge[0];
            int v = edge[1];
            int time = edge[2];
            adj.get(u).add(new Pair(v, time));
        }

        int dist[] = new int[n+1];
        for(int i = 0; i <=n ; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[k] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        // node, time;
        pq.add(new Pair(k, 0));

        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            int node = curr.node;
            int time = curr.time;

            for(Pair nbr : adj.get(node)){
                int currNode = nbr.node;
                int currTime = nbr.time;

                if(time + currTime < dist[currNode]){
                    dist[currNode] = time + currTime;
                    pq.add(new Pair(currNode, dist[currNode]));
                }
            }
        }

        int ans = -1;

        for(int i = 1; i <= n; i++){
            if(dist[i] == Integer.MAX_VALUE){
                return -1;
            }

            else{
                if(ans < dist[i]){
                    ans = dist[i];
                }
            }
        }

        return ans;
    }
}