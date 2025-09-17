
class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        int dist[][] = new int[n][n];

// Initialising the array.
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j){
                    dist[i][j] = 0;
                }
                else{
                    dist[i][j] = (int)1e8;
                }
            }
        }

// Filling the distance array with given distance .
        for(int edge[] : edges){
            int i = edge[0];
            int j = edge[1];
            int dis = edge[2];

            // edge from i to j ( i -> j)
            dist[i][j] = dis;

            // edge from j to i (j -> i)
            dist[j][i] = dis;
        }

        // Finding the distance from all the nodes to all other nodes. : Applying the Floyad warshal.
        for(int via = 0; via < n; via++){
            for(int i =0 ; i < n; i++){
                for(int j =0; j < n; j++){
                    dist[i][j] = Math.min(dist[i][j], dist[i][via] + dist[via][j]);
                }
            }
        }

        int city = -1;
        int miniNbrs = n;
// Finding the city having the less nbrs.
        for(int i = 0; i < n; i++){
            int count = 0;
            for(int j =0 ; j < n; j++){
                if(dist[i][j] <= distanceThreshold){
                    count++;
                }
            }

            if(count <=  miniNbrs){
                city = i;
                miniNbrs = count;
            }
        }

        return city;
    }

    
}