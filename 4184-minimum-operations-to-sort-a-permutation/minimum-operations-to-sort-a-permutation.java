class Solution {
    
    public boolean checkIfIncreasing(int nums[], int minIdx, int n){
        int i = 0;
        for(i = minIdx; i < n + minIdx; i++){
            if(nums[(i+1)%n]-1 != nums[i%n]){
                break;
            }
        }

        if((i+1) % n == minIdx){
            return true;
        }
        return false;
    }

    public void reverse(int nums[]){
        int i = 0;
        int j = nums.length-1;
        while(i <= j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
    public int minOperations(int[] nums) {
        // finding the minIDx, idx having value as zero will be the minIdx value.
        int minIdx = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                minIdx = i;
                break;
            }
        }
        int n = nums.length;
        
        // checking if increasing or decreasing.
        boolean isIncreasing = checkIfIncreasing(nums, minIdx, n);
        boolean isDecreasing = false;

        if(!isIncreasing){
            reverse(nums);
            minIdx = n - minIdx - 1;
            isDecreasing = checkIfIncreasing(nums, minIdx, n);
        }

        // if not increasing or decreasing, just return -1;
        if(!isIncreasing && !isDecreasing){
            return -1;
        }

        
        int minOps = n;
        if(isIncreasing){
            minOps = Math.min(minIdx, 2 + n - minIdx);
        }
        else{
            minOps = Math.min(1+minIdx, 1 + n - minIdx);
        }
        return minOps;
    }
}