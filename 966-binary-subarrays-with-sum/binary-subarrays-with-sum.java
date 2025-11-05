class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int ans = 0;
        // Generating all the subarrays with sum equal to Goal and count it.
        for(int i = 0; i < nums.length; i++){
            int sum = 0;
            for(int j = i; j < nums.length; j++){
                sum += nums[j];
                if(sum == goal){
                    ans++;
                }
            }
        }

        return ans;
    }
}