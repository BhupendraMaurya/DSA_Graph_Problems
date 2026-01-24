class Solution {
    public int maxCoins(int i, int j, ArrayList<Integer> list, int dp[][]){
        if(i > j){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int mini = Integer.MIN_VALUE;
        for(int idx = i; idx <= j; idx++){
            int coins = list.get(i-1)*list.get(idx)*list.get(j+1) + maxCoins(i, idx-1, list, dp) + maxCoins(idx+1, j, list, dp);
            mini = Math.max(mini, coins);
        }
        return dp[i][j] = mini;
    }
    public int maxCoins(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        for(int val : nums){
            list.add(val);
        }
        list.add(1);

        int n = nums.length;
        int dp[][] = new int[n+2][n+2];
        for(int rows[] : dp){
            Arrays.fill(rows, -1);
        }
        return maxCoins(1, n, list, dp);
    }
}