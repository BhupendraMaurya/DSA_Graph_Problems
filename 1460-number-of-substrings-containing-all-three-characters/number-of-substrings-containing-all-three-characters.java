class Solution {
    public int atMost(String s, int k){
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int n = s.length();
        while(j < n){
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j),0)+1);

            while(map.size() > k && i <= j){
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)-1);
                if(map.get(s.charAt(i)) == 0){
                    map.remove(s.charAt(i));
                }
                i++;
            }

            ans += j-i+1;
            j++;
        }
        return ans;
    }
    public int numberOfSubstrings(String s) {
        // Taking the reference of the problem: Find the count of subarray having sum as k.
        // So First finding the count of substring having distinct characters <= 3 - count of subtring
        // having distinct characters <= 2. 
        // HEre taking 'K' as 3, because it is given that we have 3 chars.
        int k = 3;
        return atMost(s, k) - atMost(s, k-1);
    }
}