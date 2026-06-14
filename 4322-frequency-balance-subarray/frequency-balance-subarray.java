class Solution {
    public boolean everyElementHasminOrMaxinCurrentSubarray(int i, int j, HashMap<Integer, Integer> map, int mini, int maxi, int nums[]){
        for(int freq : map.values()){
            // System.out.println("freq: "+freq+"MINI: "+mini+"MAXI: "+maxi);
            if(freq != mini && freq != maxi){
                return false;
            }
        }
        return true;
    }
    public int getLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        if(map.size() == 1){
            return nums.length;
        }
        else if(map.size() == nums.length){
            return 1;
        }
        int maxLen = 0;
        for(int i = 0; i < nums.length; i++){
            HashMap<Integer, Integer> map2 = new HashMap<>();
            
            for(int j = i; j < nums.length; j++){
                int mini = Integer.MAX_VALUE;
                int maxi = Integer.MIN_VALUE;
                map2.put(nums[j], map2.getOrDefault(nums[j], 0)+1);
                
                for(int freq : map2.values()){
                    mini = Math.min(mini, freq);
                }
                for(int freq : map2.values()){
                    maxi = Math.max(freq, maxi);
                }
                if(everyElementHasminOrMaxinCurrentSubarray(i, j, map2, mini, maxi, nums) && (mini * 2 == maxi)){
                    maxLen = Math.max(maxLen, j-i+1);
                }
            }
        }
        return maxLen;
    }
}