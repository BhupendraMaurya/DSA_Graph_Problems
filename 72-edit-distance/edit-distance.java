class Solution {
    
    public int minDistance(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int prev[] = new int[m+1];
        
        for(int j = 0; j <= m; j++){
            prev[j] = j;
        }

        // for(int i = 0; i <= n; i++){
        //     dp[i][0] = i;
        // }

        for(int i = 1; i <= n; i++){
            int curr[] = new int[m+1];
            curr[0] = i;
            for(int j = 1; j <= m ; j++){
                
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    curr[j] = prev[j-1];
                } 
                else{
                    int insert = 1 + curr[j-1];
                    int replace = 1 + prev[j-1];
                    int delete = 1 + prev[j];

                    curr[j] = Math.min(insert, Math.min(replace, delete));
                }
            }
            prev = curr;
        }

        return prev[m];
        
    }
}