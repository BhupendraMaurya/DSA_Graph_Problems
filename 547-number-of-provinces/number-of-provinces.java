class Edge{
    int s;
    int d;

    Edge(int s, int d){
        this.s = s;
        this.d = d;
    }
}
class DisjointSet{
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    
    public DisjointSet(int n){
        for(int i = 0; i < n; i++){
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
class Solution {
    // Solving this problem using : DisjointSet Algorithm.
    public int findCircleNum(int[][] isConnected) {
        // given matrix is representing the adjacency matrix of graph, so converting it into the
        //adjacency list.
        
        int n = isConnected.length;

        DisjointSet ds = new DisjointSet(n);

        for(int i = 0; i < n; i++){
            for(int j =0 ; j < n; j++){
                if(isConnected[i][j] == 1){
                    ds.unionBySize(i, j);
                }
            }
        }
        int count = 0;

        // If ultimate parent of any node is itself, that is the boss, then just count it
        // Basically, we have to count the ultimate parent in the given graph, 
        for(int i = 0; i < n; i++){
            if(ds.parent.get(i) == i){
                count++;
            }
            
        }

        return count;

    }
}