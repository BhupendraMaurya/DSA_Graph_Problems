class Solution {
    public int totalFruit(int[] fruits) {
        int ans = 0;
        int n = fruits.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        int i = 0;
        int j = 0;
        while(j < n){
            map.put(fruits[j], map.getOrDefault(fruits[j],0)+1);

            if(map.size() <= 2){
                ans = Math.max(ans, j-i+1);
            }
            else if(map.size() > 2){
                while(i < j && map.size() > 2){
                    map.put(fruits[i], map.getOrDefault(fruits[i],0)-1);
                    if(map.get(fruits[i]) == 0){
                        map.remove(fruits[i]);
                    }
                    i++;
                }  
                ans = Math.max(j-i+1, ans);
            }
            j++;
        }

        return ans;
    }
}