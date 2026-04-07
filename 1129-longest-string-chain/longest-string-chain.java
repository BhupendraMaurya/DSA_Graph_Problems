class Solution {
    public boolean isPredecessor(String s1, String s2){
        if(s1.length() + 1 != s2.length()){
            return false;
        }

        int i = 0;
        int j = 0;
        while(i < s1.length() && j < s2.length()){
            if(s1.charAt(i) == s2.charAt(j)){
                i++;
            }
            j++;
        }
        return i == s1.length();
    }
    public int f(int i, int pIdx, String words[], int dp[][]){
        if(i >= words.length){
            return 0;
        }
        if(dp[i][pIdx+1] != -1){
            return dp[i][pIdx+1];
        }

        int notTake = f(i+1, pIdx, words, dp);
        int take = Integer.MIN_VALUE;
        if(pIdx == -1 || isPredecessor(words[pIdx], words[i])){
            take = 1 + f(i+1, i, words, dp);
        }
        return dp[i][pIdx+1] = Math.max(take, notTake);
    }
    
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (s1, s2) -> s1.length() - s2.length());
        int n = words.length;
        int dp[][] = new int[n+1][n+1];
        
        for(int i = 0; i <= n; i++){
            dp[n][i] = 0;
        }

        for(int i = n-1; i >= 0; i--){
            for(int j = i-1; j >= -1; j--){
                int notTake = dp[i+1][j+1];
                int take = Integer.MIN_VALUE;
                if(j == -1 || isPredecessor(words[j], words[i])){
                    take = 1 + dp[i+1][i+1];
                }
                dp[i][j+1] = Math.max(take, notTake);
            }
        }
        return dp[0][0];
    }
}