class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans  =0;
        HashMap<Character, Integer> map = new HashMap<>();

        int i  =0;
        int j  =0;
        int n = s.length();
        while(i < n){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
            if(map.size() == i-j+1){ 
                ans = Math.max(i-j+1, ans);
            }
            else{
                while(map.size() < i-j+1){
                    map.put(s.charAt(j), map.getOrDefault(s.charAt(j),0)-1);
                    if(map.get(s.charAt(j)) == 0){
                        map.remove(s.charAt(j));
                    }
                    j++;  
                }
            }
            i++;
        }
        return ans;
    }
}