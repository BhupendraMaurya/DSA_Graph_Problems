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
        int dp[][][] = new int[n+1][3][3];
        


        for(int i = n-1; i >= 0; i--){
            for(int buy = 0; buy <= 1; buy++){
                for(int cap = 2; cap >= 1; cap--){
                    if(buy == 1){
                        int b1 = -prices[i] + dp[i+1][buy-1][cap];
                        int b2 = dp[i+1][buy][cap];
                        dp[i][buy][cap] = Math.max(b1, b2);
                    }
                    else{
                        int s1 = prices[i] + dp[i+1][buy+1][cap-1];
                        int s2 = dp[i+1][buy][cap];

                        dp[i][buy][cap] = Math.max(s1, s2);
                    }
                }
            }
        }
        return dp[0][1][2];
    }
}