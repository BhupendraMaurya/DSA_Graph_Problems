class Solution {
    public int upperBound(int a[][], int val, int hi){
        int low = 0;
        int high = hi;

        int idx = -1;

        while(low <= high){
            int mid = low + (high - low)/2;
            if(a[mid][0] <= val){
                idx = mid;
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }

        return idx;
    }
    public int maxCapacity(int[] costs, int[] capacity, int budget) {
        int n = costs.length;

        int a[][] = new int[n][2];
        for(int i =  0; i < n; i++){
            a[i][0] = costs[i];
            a[i][1] = capacity[i];
        }

        Arrays.sort(a, (x, y) -> x[0] - y[0]);

        int best[] = new int[n];
        best[0] = a[0][1];

        for(int i = 1; i < n; i++){
            best[i] = Math.max(best[i-1], a[i][1]);
        }

        int ans = 0;
        // case 1: picking one one item.
        for(int i = 0; i < n; i++){
            if(a[i][0] < budget){
                ans = Math.max(ans, a[i][1]);
            }
        }

        // case 2: picking two items.
        for(int j = 1; j < n; j++){
            int rem = budget - a[j][0] - 1;
            int i = upperBound(a, rem, j-1);

            if(i >= 0){
                ans = Math.max(ans, best[i] + a[j][1]);
            }
        }

        return ans;
    }
}