class Solution {
    public int price(int i, int buyOrsell, int prices[], int dp[][]){
        
        if(i == prices.length || buyOrsell >= 5){
            return 0;
        }
        if(dp[i][buyOrsell] != -1){
            return dp[i][buyOrsell];
        }

        if(buyOrsell % 2 == 0){
            int b1 = -prices[i] + price(i+1, buyOrsell+1, prices, dp);
            int b2 = price(i+1, buyOrsell, prices, dp);
            return dp[i][buyOrsell] = Math.max(b1, b2);
        }
        else{
            int s1 = prices[i] + price(i+1, buyOrsell+1, prices, dp);
            int s2 = price(i+1, buyOrsell, prices, dp);

            return dp[i][buyOrsell] = Math.max(s1, s2);
        }
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        

        int dp[][] = new int[n][5];
        for(int rows[]: dp){
            Arrays.fill(rows, -1);
        }
        return price(0, 0, prices, dp);
    }
}