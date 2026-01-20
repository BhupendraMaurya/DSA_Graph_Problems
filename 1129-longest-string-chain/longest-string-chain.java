class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        HashMap<String, Integer> map = new HashMap<>();
        int ans = 0;
        for(int i = 0; i < words.length; i++){
            map.put(words[i], 1);

            for(int j = 0; j < words[i].length(); j++){
                String str = words[i].substring(0,j) + words[i].substring(j+1);

                if(map.containsKey(str)){
                    map.put(words[i], Math.max(map.get(words[i]), map.get(str)+1));
                }
                ans = Math.max(ans, map.get(words[i]));
            }
        }
        return ans;
    }
}