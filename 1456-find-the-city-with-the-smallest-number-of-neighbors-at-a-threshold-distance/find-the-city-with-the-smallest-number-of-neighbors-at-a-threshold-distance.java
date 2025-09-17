// Steps:
/*
1. Created the 2D matrix(dist)
2. Calculated the distance from each node to other nodes.
3. Find the city having minimum nbrs.
*/ 
class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        // Step 1: Initialize the distance matrix
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    dist[i][j] = 0;  // distance to itself = 0
                } else {
                    dist[i][j] = (int) 1e8;  // infinity for now
                }
            }
        }

        // Step 2: Fill direct edge distances from the input
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];

            // Since graph is undirected
            dist[u][v] = weight;
            dist[v][u] = weight;
        }

        // Step 3: Apply Floyd–Warshall to compute all-pairs shortest paths
        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][via] + dist[via][j]);
                }
            }
        }

        // Step 4: Find the city with the smallest number of reachable neighbors
        int resultCity = -1;
        int minNeighbors = n;  // maximum possible

        for (int i = 0; i < n; i++) {
            int reachableCount = 0;
            for (int j = 0; j < n; j++) {
                if (dist[i][j] <= distanceThreshold) {
                    reachableCount++;
                }
            }

            // Pick the city with fewer neighbors, and prefer the larger index on ties
            if (reachableCount <= minNeighbors) {
                minNeighbors = reachableCount;
                resultCity = i;
            }
        }

        return resultCity;
    }
}
