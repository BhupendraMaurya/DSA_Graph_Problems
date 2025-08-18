class Solution {
    
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

            // here we are adding reverse because the question is saying that for the pair : [0, 1], it indicates that
// to take course 0, you have to take the course 1.

// Means basically, we can reverse the edges while adding in adj list and then we can apply the 
// same logic of Topo sort for this list, and it will work absolutely fine.
            adj.get(v).add(u); // adding this instead of this : adj.get(u).add(v);
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
            return topo;
        }
       
        // if not able to find the topo sort, then just return empty array.
        
        return new int [0];
    }
}