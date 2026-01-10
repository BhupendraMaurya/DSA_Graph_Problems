class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int ans[] = new int[2];
        ans[0] = -1;
        ans[1] = -1;

        int maxi = -1;
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] > maxi){
                    maxi = mat[i][j];
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }

        return ans;
    }
}