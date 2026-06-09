class Solution {

    
    public long maxTotalValue(int[] nums, int k) {
        long maxi = -1;
        long mini = Integer.MAX_VALUE;
        for(int val : nums){
            maxi = Math.max(maxi, val);
            mini = Math.min(mini, val);
        }
        return (long)(k * (long)(maxi - mini));
    }
}