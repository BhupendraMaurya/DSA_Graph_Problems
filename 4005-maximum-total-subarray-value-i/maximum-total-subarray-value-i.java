class Solution {

    
    public long maxTotalValue(int[] nums, int k) {
        Arrays.sort(nums);
        long bigValue = nums[nums.length-1];
        long smallValue = nums[0];
        return (long)(k * (bigValue - smallValue));
    }
}