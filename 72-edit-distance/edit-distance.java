class Solution {
    public int distance(int i, int j, String s1, String s2, int dp[][]){
        if(i < 0){
            return j+1;
        }
        if(j < 0){
            return i+1;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = distance(i-1, j-1, s1, s2, dp);
        }
        else{
            int insert = 1 + distance(i, j-1, s1, s2, dp);
            int replace = 1 + distance(i-1, j-1, s1, s2, dp);
            int delete = 1 + distance(i-1, j, s1, s2, dp);

            return dp[i][j] = Math.min(insert, Math.min(replace, delete));
        }
    }
    public int minDistance(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int dp[][] = new int[n+1][m+1];
        
        for(int j = 0; j <= m; j++){
            dp[0][j] = j;
        }

        for(int i = 0; i <= n; i++){
            dp[i][0] = i;
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m ; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                } 
                else{
                    int insert = 1 + dp[i][j-1];
                    int replace = 1 + dp[i-1][j-1];
                    int delete = 1 + dp[i-1][j];

                    dp[i][j] = Math.min(insert, Math.min(replace, delete));
                }
            }
        }

        return dp[n][m];
        
    }
}