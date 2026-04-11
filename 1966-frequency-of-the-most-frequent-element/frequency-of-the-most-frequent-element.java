class Solution {
    // using sliding window approach
    public int maxFrequency(int[] nums, int k) {
        // sorting the array so that all the nearest elements could come closer.
        Arrays.sort(nums);

        
        int left = 0;
        int right = 0;
        int n = nums.length;

        long ans = 0;
        long sum = 0;


        while(right < n){
            sum += nums[right];


            while((right - left +1L) * nums[right] - sum > k){
                sum -= nums[left];
                left++;
            }

            ans = Math.max(ans, right - left + 1L);
            right++;
        }

        return (int)ans;
    }
}