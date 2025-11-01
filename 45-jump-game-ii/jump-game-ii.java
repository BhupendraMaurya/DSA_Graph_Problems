class Solution {
    
    public int jump(int[] nums) {
        int n = nums.length;
        // keeping the track of the ranges where we can reach the farthest from current range.

        int left = 0;
        int right = 0;
        int jumps = 0;

        while(right < n-1){//Going till n-2, because we will return as soon as we will reach at n-1 or greater than this.

            // Finding that how much far can I reach from current range
            int farthest = 0;

            for(int ind = left; ind <= right; ind++){
                farthest = Math.max(farthest, ind + nums[ind]);
            }
            // after taking each jump, increment jump count
            jumps++;
            // after finding the farthest range, now update the next ranges.
            left = right;
            right = farthest;
        }

        return jumps;
    }

}