class Solution {
    public int calculate(int i, int items[][]){
        int count = 0;
        for(int j = 0; j < items.length; j++){
            if(j != i && items[j][0] % items[i][0] == 0){
                count++;
            }
        }
        return count;
    }
    public int solve(int i, int taken, int items[][], int budget, int ans[], int dp[][][]){
        if(i >= items.length || budget <= 0){
            return 0;
        }
        if(dp[i][budget][taken] != -1){
            return dp[i][budget][taken];
        }
        int notpick = solve(i+1, 0, items, budget, ans, dp);
        int pick = 0;
        int price = items[i][1];
        if(taken == 0){
            // first purchase , get free copies well.
            if(price <= budget){
                pick = 1 + ans[i] + solve(i, 1, items, budget-price, ans, dp);
            }
        }
        // add additional copies only add 1 item.
        else{
            if(price <= budget){
                pick = 1 + solve(i, 1, items, budget-price, ans, dp);
            }
        }
        return dp[i][budget][taken] = Math.max(pick, notpick);
    }
    public int maximumSaleItems(int[][] items, int budget) {

        int ans[] = new int[items.length];
        for(int i = 0; i < items.length; i++){
            ans[i] = calculate(i, items);
        }
        int n = items.length;
        int dp[][][] = new int[n][budget+1][2];
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= budget; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        // solve(idx=0, taken=0, items, budget, ans, dp)
        return solve(0, 0, items, budget, ans, dp);
    }
}   