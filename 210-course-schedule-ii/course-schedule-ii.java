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


        ArrayList<Integer> ans = new ArrayList<>();


        while(!q.isEmpty()){
            int curr = q.peek();
            q.remove();
            // adding the current element in the answer list as it is one of our topo sort sequence.
            ans.add(curr);


            for(int nbr : adj.get(curr)){

                inDegree[nbr]--;

                if(inDegree[nbr] == 0){
                    q.add(nbr);
                }
            }
        }

        int length = ans.size();

        int arr[] = new int[length];

        // if we are not able to do the complete topo sort logic, then just return the empty array as answer.
        if(length != V){
            return new int[0];
        }
        // storing the answer stored in the array arr from arraylist(ans).

        // question is asking the correct course order, that which should be completed first, that is why,
        // storing the answer in reverse manner ( reverse of topo sort).
        int j = 0;
        for(int i = length-1; i >= 0; i--){
            arr[j++] = ans.get(i);
        }

        return arr;
    }
}