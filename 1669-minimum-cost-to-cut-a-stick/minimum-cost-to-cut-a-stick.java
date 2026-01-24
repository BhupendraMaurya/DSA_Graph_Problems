class Solution {
    public int fun(int i, int j, ArrayList<Integer> list, int dp[][]){
        if(i > j){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int mini = Integer.MAX_VALUE;
        for(int idx = i; idx <= j; idx++){
            int cost = list.get(j+1)-list.get(i-1) + fun(i, idx-1, list, dp) + fun(idx+1, j, list, dp);
            mini = Math.min(mini, cost);
        }
        return dp[i][j] = mini; 
    }
    
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        for(int val : cuts){
            list.add(val);
        }
        list.add(n);
        int dp[][] = new int[cuts.length+2][cuts.length+2];
        // for(int i = 1; i <= cuts.length; i++){
        //     for(int j = 1; j <= cuts.length; j++){
        //         if(i > j){
        //             dp[i][j] = 0;
        //         }
        //     }
        // }
        int m = cuts.length;

        for(int i = m; i >= 1; i--){
            for(int j = 1; j <= m; j++){
                int mini = Integer.MAX_VALUE;
                if(i > j) continue;
                for(int k = i; k <= j; k++){
                    int cost = dp[i][k-1] + dp[k+1][j] + list.get(j+1) - list.get(i-1);
                    mini = Math.min(cost, mini);
                }
                dp[i][j] = mini;
            }
        }

        return dp[1][cuts.length];
    }
}