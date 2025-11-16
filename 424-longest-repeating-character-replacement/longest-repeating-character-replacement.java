class Solution {
    public int characterReplacement(String s, int k) {
        int i = 0;
        int j = 0;
        int maxLen = 0;
        int maxF = 0;
        int n = s.length();
        int hash[] = new int[26];
        Arrays.fill(hash, 0);

        while(j < n){
            hash[s.charAt(j) - 'A']++;
            maxF = Math.max(maxF, hash[s.charAt(j)-'A']);

            // If not a valid substring, then just trim it(For optimization: I'm simply removing one
            // char from last and adding one char from the front.)
            // So just removing one char from the front.
            if(j-i+1 - maxF > k){
                hash[s.charAt(i) - 'A']--;
                i++;
            }

            if(j-i+1 - maxF <= k){
                maxLen = Math.max(maxLen, j-i+1);
            }
            j++;
        }

        return maxLen;
    }
}