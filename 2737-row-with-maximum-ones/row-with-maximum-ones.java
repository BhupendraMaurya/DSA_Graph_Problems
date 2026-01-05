class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        
        int ans = -1;
        int index = -1;
        for(int i = 0; i < mat.length; i++){
            int count = 0;
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 1){
                    count++;
                }
            }
            if(count > ans){
                ans = count;
                index = i;
            }
        }

        return new int[]{index, ans};
    }
}