class Solution {
    public int price(int i, int buy, int cap, int prices[], int dp[][][]){
        if(cap == 0){
            return 0;
        }

        if(i == prices.length){
            return 0;
        }
        if(dp[i][buy][cap] != -1){
            return dp[i][buy][cap];
        }

        if(buy == 1){
            int b1 = -prices[i] + price(i+1, buy-1, cap, prices, dp);
            int b2 = price(i+1, buy, cap, prices, dp);
            return dp[i][buy][cap] = Math.max(b1, b2);
        }
        else{
            int s1 = prices[i] + price(i+1, buy+1, cap-1, prices, dp);
            int s2 = price(i+1, buy, cap, prices, dp);

            return dp[i][buy][cap] = Math.max(s1, s2);
        }
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][][] = new int[n][2][3];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 2; j++){
                for(int k = 0; k < 3; k++){
                    dp[i][j][k] = -1;
                }
            }
        }

        return price(0, 1, 2, prices, dp);
    }
}