class DisjointSet{
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    
    public DisjointSet(int n){
        for(int i = 0; i <= n; i++){
            parent.add(i);
            size.add(1);
        }
    }
    
    int findUpar(int node){
        if(node == parent.get(node)){
            return node;
        }
        
        // taking the ultimate parent from prev recursive call.
        int ulp = findUpar(parent.get(node));
        // now, sett ing the parent of node as ulp.
        parent.set(node, ulp);
        
        // returning the parent of current node.
        return parent.get(node);
    }
    
    void unionBySize(int u, int v){
        // finding the ultimate parent of node u and v.
        int ulp_u = findUpar(u);
        int ulp_v = findUpar(v);
        
        // if ultimate parent of node u and v is equal, then just return, as no need to do anything,
        // because, they are already in the same component and sharing the common parent.
        if(ulp_u == ulp_v){
            return;
        }
        
        if(size.get(ulp_u) < size.get(ulp_v)){
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
        }
        
        else{
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}

class Edge{
    int src;
    int dest;

    
    Edge(int src, int dest){
        this.src = src;
        this.dest = dest;
    }

}

class Solution {
    // It was this here: int[][] connections, but changing it as edges, because I have prewritten
    // vode.
    public int makeConnected(int V, int[][] edges) {
        int len = edges.length;

        List<Edge> adj = new ArrayList<Edge>();

        for(int edge[] : edges){
            int s = edge[0];
            int d = edge[1];
            adj.add(new Edge(s, d));
        }
     
        DisjointSet ds = new DisjointSet(V);
        
        int components = 0;
        int extraEdges = 0;
        
        for(int i = 0; i < adj.size(); i++){
            int u = adj.get(i).src;
            int v = adj.get(i).dest;
            
            if(ds.findUpar(u) != ds.findUpar(v)){
                ds.unionBySize(u, v);
            }
            else{
                extraEdges++;
            }
        }
        
        for(int i = 0; i < V; i++){
            if(ds.parent.get(i) == i){
                components++;
            }
        }

        int ans = components-1;
        if(ans <= extraEdges){
            return ans;
        }

        return -1;

    }
}