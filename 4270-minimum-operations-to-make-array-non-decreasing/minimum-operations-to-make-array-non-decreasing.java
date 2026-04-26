class Solution {
    public long minOperations(int[] nums) {
        long sum = 0;
        for(int i = nums.length-2; i >= 0; i--){
            if(nums[i] > nums[i+1]){
                sum += nums[i] - nums[i+1];
            }
        }
        return sum;
    }
}