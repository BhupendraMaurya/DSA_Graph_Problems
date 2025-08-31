class Edge{
    int node;
    int price;

    Edge(int node, int price){
        this.node = node;
        this.price = price;
    }
}

class Pair{
    int stop;
    int node;
    int price;

    Pair(int stop, int node, int price){
        this.stop = stop;
        this.node = node;
        this.price = price;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
        for(int i = 0 ; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int edge[] : flights){
            int u = edge[0];
            int v = edge[1];
            int price = edge[2];

            adj.get(u).add(new Edge(v, price));
        }

        Queue<Pair> q = new LinkedList<>();
        // stops, nodes, price;
        q.add(new Pair(0, src, 0));

        int dist[] = new int[n];
        for(int i = 0; i < n; i++){
            dist[i] = Integer.MAX_VALUE;
        }

        dist[src] = 0;

        while(!q.isEmpty()){
            Pair curr = q.remove();
            int stop = curr.stop;
            int node = curr.node;
            int price = curr.price;

            for(Edge nbr : adj.get(node)){
                int currNode = nbr.node;
                int wt = nbr.price;

                if(price + wt < dist[currNode] && stop <= k){
                    dist[currNode] = price + wt;
                    q.add(new Pair(stop+1, currNode, dist[currNode]));
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];

    }
}