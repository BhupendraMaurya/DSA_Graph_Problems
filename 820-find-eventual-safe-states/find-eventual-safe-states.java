class Solution {

    // Intuition : Since we know that terminal node will not be having outgoing edges, it can have only incoing edges.
    // So if somehow are can find out the total number of nodes whose destination is these terminal nodes.

    // Now, suppose, If I'm changing my given graph's edges, like from u -> v to v->u. Then, we have to find that, 
    // all the nodes who do not have any incoming edges. Means, nodes with inDegree as Zero(0).

    // So simply applying the Topo sort on the reversed graph and only taking that node whose inDegree is zero while removing the edges.


    public List<Integer> eventualSafeNodes(int[][] graph) {
       
        int V = graph.length;

        // now reversing the Adjacency list.(basically reversing the edges).
        ArrayList<ArrayList<Integer>> adjRev = new ArrayList<>();
        int inDegree[] = new int[V];

        for(int i = 0; i < V; i++){
            adjRev.add(new ArrayList<>());
        }

        for(int i = 0; i < V; i++){
           
            for(int j = 0; j < graph[i].length; j++){
               
                adjRev.get(graph[i][j]).add(i);
                inDegree[i]++; // since we are making an edges from v --> j, that is why increasing the inDegree of node 'j'.
            }
           
        }

        Queue<Integer> q = new LinkedList<>();

        // Now, applying the topo sort logic.
        for(int i = 0; i < V; i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }

        List<Integer> safeNodes = new ArrayList<>();

        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();

            safeNodes.add(node);

            for(int nbr : adjRev.get(node)){

                inDegree[nbr]--;

                if(inDegree[nbr] == 0){
                    q.add(nbr);
                }
            }
        }

        for(ArrayList<Integer> list : adjRev){
            System.out.println(list);
        }
        Collections.sort(safeNodes);
        return safeNodes;
        
        
    }
}