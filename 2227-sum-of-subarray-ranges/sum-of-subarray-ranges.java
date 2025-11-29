class Solution {
    public long subArrayRanges(int[] nums) {
        
        long sum = 0;
        for(int i = 0;i  < nums.length; i++){
            
            for(int j = i; j < nums.length; j++){
                int maxi = Integer.MIN_VALUE;
                int mini = Integer.MAX_VALUE;
                for(int k = i; k <= j; k++){
                    maxi = Math.max(nums[k], maxi);
                    mini = Math.min(nums[k], mini);
                }

                sum += maxi - mini;
            }
        }

        return sum;
    }
}