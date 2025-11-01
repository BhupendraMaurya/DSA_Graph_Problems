class Solution {
    public boolean canJump(int[] nums) {

        if(nums.length == 1){
            return true;
        }

        if(nums[0] == 0){
            return false;
        }
        int availableSteps = nums[0];

        for(int i = 1; i < nums.length; i++){
            availableSteps--;

            availableSteps = Math.max(availableSteps, nums[i]);

            if(availableSteps == 0 && i != nums.length-1){
                return false;
            }
        }

        return true;
    }
}