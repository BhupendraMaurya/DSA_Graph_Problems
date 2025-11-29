class Solution {
    public long subArrayRanges(int[] nums) {
        
        long sum = 0;
        for(int i = 0;i  < nums.length; i++){
            int maxi = Integer.MIN_VALUE;
            int mini = Integer.MAX_VALUE;
            for(int j = i; j < nums.length; j++){
                
                maxi = Math.max(nums[j], maxi);
                mini = Math.min(nums[j], mini);

                sum += maxi - mini;
            }
        }

        return sum;
    }
}