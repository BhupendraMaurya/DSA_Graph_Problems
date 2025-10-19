class Solution {

     
    
    // Main function to check if the hand can be rearranged into groups
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int val : hand){
            minHeap.add(val);
        }

        while(minHeap.size() != 0){
            int start = minHeap.poll();
            for(int j = 1; j < groupSize; j++){
                // It checks that whether (start + j) exists in the minHeap or not.
                // If yes, then it just removes it and continue for next iteration.
                // If does not exist then just return false.
                if(minHeap.remove(start+j)){
                    continue;
                }
                else{
                    return false;
                }
            }
        }

        return true;
        
    }
}
