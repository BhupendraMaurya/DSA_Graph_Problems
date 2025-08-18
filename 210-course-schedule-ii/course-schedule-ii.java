class Solution {
    public void reverse(int topo[]){

        int i = 0;
        int j = topo.length-1;
        while(i < j){
            int temp = topo[i];
            topo[i] = topo[j];
            topo[j] = temp;
            i++;
            j--;
        }
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        int V = numCourses;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }

        int inDegree[] = new int[V];

        for(int edge[] : prerequisites){
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
        }

        for(int i = 0; i < V; i++){
            for(int j = 0; j < adj.get(i).size(); j++){
                inDegree[adj.get(i).get(j)]++;
            }
        }

        // Using Toposort to find the correct course order
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < V; i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }

        int topo[] = new int[V];
        int idx = 0;

        while(!q.isEmpty()){
            int curr = q.peek();
            q.remove();
            // adding the current element in the topo sort as it is one of our topo sort sequence.
           
            topo[idx++] = curr;

            for(int nbr : adj.get(curr)){

                inDegree[nbr]--;

                if(inDegree[nbr] == 0){
                    q.add(nbr);
                }
            }
        }

        

        // if idx has become equal to total Nodes, that means we were able to find the Topo sort, so return it.
        if(idx == V){
            reverse(topo);
            return topo;
        }
       
        // if not able to find the topo sort, then just return empty array.
        
        return new int [0];
    }
}