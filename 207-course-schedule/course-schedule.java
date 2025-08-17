class Solution {

    // bacically checking for : Check for cycle in directed cyclic graph.
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        int V = numCourses;
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }

        for(int edge[] : prerequisites ){
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
        }

        int inDegree[] = new int[V];

// calculating the inDegree of given graph.
        for(int i = 0; i < V; i++){
            for(int j = 0; j < adj.get(i).size(); j++){
                inDegree[adj.get(i).get(j)]++;
            }
        }
        int count = 0;

        Queue<Integer> q = new LinkedList<>();

// is any node is having the indegree as zero, then adding thm in the queue.
        for(int i = 0; i < V; i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }

        // using BFS
        while(!q.isEmpty()){
            
            int curr = q.peek();
            q.remove();

            count++;// increasing the count as we are counting the total numbers in topo sort.

            for(int nbr : adj.get(curr)){
                inDegree[nbr]--;

                if(inDegree[nbr] == 0){
                    q.add(nbr);
                }
            }


        }

        // if total Topo sort elements are equal to total Nodes, that means we can finish all the courses
        // otherwise return false.
        if(count == V){
            return true;
        }

        return false;
    }
}