class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[] = new int[nums.length];
        int n = nums.length;
        Arrays.fill(dp, 1);
        int maxi = 1;
        for(int i = 0; i < n; i++){
            for(int pidx = 0; pidx < i; pidx++){
                if(nums[i] > nums[pidx] && 1 + dp[pidx] > dp[i]){
                    dp[i] = 1 + dp[pidx];
                    maxi = Math.max(maxi, dp[i]);
                }
            }
        }
        return maxi;
        
    }
}