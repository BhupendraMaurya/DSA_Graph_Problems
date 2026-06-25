class Solution {
    public int totalFruit(int[] fruits) {
        int ans = 0;
        int left = 0;
        int right = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = fruits.length;

        while(right < n){
            map.put(fruits[right], map.getOrDefault(fruits[right],0)+1);
            if(map.size() <= 2){
                ans = Math.max(ans, right-left+1);
            }
            else{
                while(map.size() > 2){
                    map.put(fruits[left], map.getOrDefault(fruits[left],0)-1);
                    if(map.get(fruits[left]) == 0){
                        map.remove(fruits[left]);
                    }
                    left++;
                }
            }
            right++;  
        }
        return ans;
    }
}