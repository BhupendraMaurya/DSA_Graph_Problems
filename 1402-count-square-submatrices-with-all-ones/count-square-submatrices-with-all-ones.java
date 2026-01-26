class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int dp[][] = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0){
                    dp[i][j] = matrix[i][j];
                }
                else if(j == 0){
                    dp[i][j] = matrix[i][j];
                }

            }
        }


        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i][j] == 0){
                    dp[i][j] = 0;
                }
                
                else{
                    int mini = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]));
                    dp[i][j] = mini + 1;
                }
            }
        }

        int totalSqr = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(dp[i][j] != 0){
                    totalSqr += dp[i][j];
                }
            }
        }

        return totalSqr;
    }
}