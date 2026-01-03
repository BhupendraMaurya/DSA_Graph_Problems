class Solution {
    public boolean isValid(int nums[], int k, int maxSum){
        int count = 1;
        int sum = 0;

        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(sum > maxSum){
                count++;
                sum = nums[i];
            }
            if(count > k){
                return false;
            }
        }

        return true;
    }

    // This problem is exactly same like: Allocate minimum pages of GFG:
    // https://www.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1
    public int splitArray(int[] nums, int k) {
        if(k > nums.length){
            return -1;
        }
        int maxi = 0;
        int sum = 0;

        for(int i = 0; i < nums.length; i++){
            maxi = Math.max(nums[i], maxi);
            sum += nums[i];
        }

        int ans = Integer.MIN_VALUE;
        int low = maxi;
        int high = sum;

        while(low <= high){
            int mid = high + (low - high) / 2;
            
            if(isValid(nums, k, mid)){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        };

        return ans;
    }
}