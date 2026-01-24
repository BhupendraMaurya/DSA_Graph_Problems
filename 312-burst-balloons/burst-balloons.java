class Solution {
    
    public int maxCoins(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        for(int val : nums){
            list.add(val);
        }
        list.add(1);

        int n = nums.length;
        int dp[][] = new int[n+2][n+2];
        
        
        for(int i = n; i >= 1; i--){
            for(int j = 1; j <= n; j++){
                if(i > j){
                    continue;
                }
                int maxi = Integer.MIN_VALUE;
                for(int idx = i; idx <= j; idx++){
                    int coins = list.get(i-1)*list.get(idx)*list.get(j+1) + dp[i][idx-1] + dp[idx+1][j];
                    maxi = Math.max(coins, maxi);
                }
                dp[i][j] = maxi;
            }
        }

        return dp[1][n];
    }
}