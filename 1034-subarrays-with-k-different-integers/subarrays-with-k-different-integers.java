class Solution {
    public int atMost(int nums[], int k){
        int ans = 0;
        int i = 0;
        int j = 0;
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        while(j < n){
            map.put(nums[j], map.getOrDefault(nums[j],0)+1);

            while(map.size() > k && i <= j){
                map.put(nums[i], map.getOrDefault(nums[i],0)-1);

                if(map.get(nums[i]) == 0){
                    map.remove(nums[i]);
                }
                i++;
            }
            ans += j-i+1;
            j++;
        }

        return ans;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k-1);
    }
}