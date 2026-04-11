class Solution {
    // using sliding window approach
    public int maxFrequency(int[] nums, int k) {
       Arrays.sort(nums);
       int left = 0;
       int right = 0;
       long totalSum = 0;
       long freq = 0;
       while(right < nums.length){
            totalSum += nums[right];
            while(left <= right && nums[right] * (right-left+1L) > totalSum + k){
                totalSum -= nums[left];
                left++;
            }
            freq = Math.max(freq, right-left+1L);
            right++;
       }
       return (int)freq;

    }
}