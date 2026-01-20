class Solution {
    public boolean isPredecessor(String s1, String s2){
        if(s1.length() != s2.length()+1){
            return false;
        }
        int n = s1.length();
        int m = s2.length();

        int i = 0, j = 0;
        while(i < n){
            if(j < m && s1.charAt(i) == s2.charAt(j)){
                i++;
                j++;
            }
            else{
                i++;
            }
        }
        return i == n && j == m; 

    }
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        int dp[] = new int[words.length];
        Arrays.fill(dp, 1);

        int ans = 0;
        for(int i = 0; i < words.length; i++){
            for(int j = 0; j < i; j++){
                if((isPredecessor(words[i], words[j])) && (1 + dp[j] > dp[i])){
                    dp[i] = 1 + dp[j];
                }
            }
        }
        for(int i = 0; i < dp.length; i++){
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}