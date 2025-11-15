class Solution {
    
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i),0)+1);
        }

        int count = map.size();
        int ans = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;
        int n = s.length();
        int start = 0;

        while(j < n){
            if(map.containsKey(s.charAt(j))){
                map.put(s.charAt(j), map.get(s.charAt(j))-1);

                if(map.get(s.charAt(j)) == 0){
                    count--;
                }
            }

           
            while(count == 0){
                if(map.containsKey(s.charAt(i))){
                    map.put(s.charAt(i), map.get(s.charAt(i))+1);

                    if(map.get(s.charAt(i)) == 1){
                        if(j-i+1 < ans){
                            ans = Math.min(ans, j-i+1);
                            start = i; 
                        }
                        count++;
                    }

                }
                i++;
            }
            j++;
            
        }

        return ans == Integer.MAX_VALUE ? "" : s.substring(start, start + ans);
    }
}