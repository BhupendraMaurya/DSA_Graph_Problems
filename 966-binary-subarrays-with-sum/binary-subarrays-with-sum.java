class Solution {
    public int atMost(int nums[], int goal){
        int i = 0;
        int j = 0;
        int n = nums.length;

        int ans = 0;
        int sum = 0;
        while(j < n){
            sum += nums[j];

            while(sum > goal && i <= j){
                sum -= nums[i];
                i++;
            }

            ans += j-i+1;
            j++;
        }
        return ans;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal-1);
    }
}