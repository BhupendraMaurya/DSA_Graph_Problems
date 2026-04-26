class Solution {
    public long minOperations(int[] nums) {
        long ans = 0; // answer to store the total operations requiered to make the array non decreasing. 
        long curr = 0; // total operations we have now(left from previous operations);

        for(int i = 1; i < nums.length; i++){
            // calculating that how much extra needed to make the current element equal or greater than its previous higher.
            long need = Math.max(0, curr + nums[i-1] - nums[i]);
            if(need > curr){//if need is greater thanb current I have, then just add the difference between them. 
                ans += need - curr;
            }
            // and whatever operations I have left, I can apply it in next, if possible
            curr = need;
        }

        return ans;
    }
}