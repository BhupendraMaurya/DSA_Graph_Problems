class Solution {
    public boolean found(int matrix[][], int target, int i){
        int low = 0;
        int high = matrix[0].length-1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(matrix[i][mid] == target){
                return true;
            }
            else if(matrix[i][mid] < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }

        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        

        for(int i = 0; i < n; i++){
            if(found(matrix, target, i)){
                return true;
            }
        }
        return false;
    }
}