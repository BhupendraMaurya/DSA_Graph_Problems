class Solution {
    public long countPairs(String[] word) {
        long ans = 0;
        // map to store the normalized pattern for each string.
        HashMap<String, Long> map = new HashMap<>();
        
        for(String str : word){
            // Taking each string and converting it into its coresponding array
            char pattern[] = str.toCharArray();
            
            // now taking the first character of given string for the reference to make the pattern
            int ref = pattern[0];
            // using this loop, I'm simply finding the normalized pattern
            for(int i = 0; i < pattern.length; i++){
                pattern[i] = (char)((pattern[i] - ref + 26) % 26);
            }

            // Since, we have stored the normalized pattern in an array, so storing this in the string now.
            String normalized = new String(pattern);

            // now, checking that, is this pattern already available in the map or not, if yes, find its count.
            long count = (long)map.getOrDefault(normalized, 0L);

            // If your normalied pattern already present in the map, that means, you have already got the 
            // similar string, so count the total count it has appeared before.
            ans += count;

            // in the last, add this normalized pattern again the map with updated count.
            map.put(normalized, count+1);
        }

        return ans;
    }
}