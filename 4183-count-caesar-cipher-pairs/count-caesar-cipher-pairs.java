class Solution {
    public long countPairs(String[] word) {
        long ans = 0;

        // Map to store the generalized form of all the strings.
        HashMap<String, Integer> map = new HashMap<>();

        // Taking each string from the map and finding other form 
        for(String s : word){


            char ch[] = s.toCharArray();
            // taking the first character as reference and then finding
            int f = ch[0];

            
            for(int i = 0; i < s.length(); i++){
                ch[i] = (char)(((ch[i]) - f + 26) % 26);
            }

            String newStr = new String(ch);

            // finding the Freq of newStr and if not present, then return 0.
            int cnt = map.getOrDefault(newStr, 0);

            // adding answer in our variable.
            ans += cnt;

            // now storing the newStr with added count in the map.
            map.put(newStr, cnt+1);

        }
        return ans;
    }
}