class Solution {

     
    public boolean isAdjacent(int hand[], int i, int n, int groupSize){

        int nextNum = hand[i] + 1;
        hand[i] = -1;
        int count = 1;
        i++;

        while(i < n && count < groupSize){
            if(nextNum == hand[i]){
                count++;
                nextNum = hand[i] + 1;
                hand[i] = -1;
            }
            i++;
        }

        if(count < groupSize){
            return false;
        }

        return true;
    }
    // Main function to check if the hand can be rearranged into groups
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;

        if(n % groupSize != 0){
            return false;
        }

        Arrays.sort(hand);

        for(int i = 0; i < n; i++){
            if(hand[i] >= 0){
                if(!isAdjacent(hand, i, n, groupSize)){
                    return false;
                }
            }
        }

        return true;
    }
}
