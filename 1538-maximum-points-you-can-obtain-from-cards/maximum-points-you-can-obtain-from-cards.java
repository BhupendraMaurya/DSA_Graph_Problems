class Solution {
    public int maxScore(int[] cardPoints, int k) {
        
        int maxScore = 0;
        int lscore = 0;
        int rscore = 0;
        for(int i = 0; i < k; i++){
            lscore += cardPoints[i];
        }
        // Making lsum as MaxScore
        maxScore = lscore;

        int rIndex = cardPoints.length-1;
        for(int i = k-1; i >= 0; i--){
            lscore -= cardPoints[i];
            rscore += cardPoints[rIndex--];
            maxScore = Math.max(lscore+rscore, maxScore);
        }
        return maxScore;
    }
}