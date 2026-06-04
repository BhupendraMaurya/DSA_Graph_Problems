class Solution {
    public long minOperations(int[] nums) {
        long ans = 0;   // total operations needed
        
        int k = 0;
        int j = nums.length-1;
        while(k < j){
            int temp = nums[k];
            nums[k] = nums[j];
            nums[j] = temp;
            k++;
            j--;
        }

        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i-1]){
                ans += nums[i] - nums[i-1];
            }
        }

        return ans;

    }
}