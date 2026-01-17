class Solution {
    public int memo(int n, int dp[]){
        if(n == 0 || n == 1){
            return n;
        }

        if(dp[n] != -1){
            return dp[n];
        }
        dp[n] = memo(n-1, dp) + memo(n-2, dp);
        return dp[n];
    }
    public int fib(int n) {
        if(n == 0){
            return 0;
        }
        // memoization approach
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;

        memo(n, dp);
        return dp[n];
    }
}