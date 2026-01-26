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
        int next[][] = new int[3][3];
        


        for(int i = n-1; i >= 0; i--){
            int curr[][] = new int[3][3];
            for(int buy = 0; buy <= 1; buy++){
                for(int cap = 2; cap >= 1; cap--){
                    if(buy == 1){
                        int b1 = -prices[i] + next[buy-1][cap];
                        int b2 = next[buy][cap];
                        curr[buy][cap] = Math.max(b1, b2);
                    }
                    else{
                        int s1 = prices[i] + next[buy+1][cap-1];
                        int s2 = next[buy][cap];

                        curr[buy][cap] = Math.max(s1, s2);
                    }
                }
            }
            next = curr;
        }
        return next[1][2];
    }
}