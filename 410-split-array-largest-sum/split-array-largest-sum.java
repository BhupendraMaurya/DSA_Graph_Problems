class Solution {
    public boolean isValid(int arr[], int k, int maxPages){
        int student = 1;
        int sumOfPages = 0;
        
        for(int i = 0; i < arr.length; i++){
            sumOfPages += arr[i];
            
            if(sumOfPages > maxPages){
                student++;
                sumOfPages = arr[i];
            }
            
            if(student > k){
                return false;
            }
        }
        
        return true;
    }
    
    public int splitArray(int[] arr, int k) {
        if(k > arr.length){
            return -1;
        }
        
        int maxi = 0;
        int sum = 0;
        
        for(int i = 0; i < arr.length; i++){
            maxi = Math.max(maxi, arr[i]);
            sum += arr[i];
        }
        
        int low = maxi;
        int high = sum;
        int ans = -1;
        
        while(low <= high){
            int mid = high + (low - high) / 2;
            
            if(isValid(arr, k, mid)){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        
        return ans;
    }
}