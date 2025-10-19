class Solution {

     
    
    // Main function to check if the hand can be rearranged into groups
    public boolean isNStraightHand(int[] hand, int groupSize) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for(int i = 0; i < hand.length; i++){
            map.put(hand[i], map.getOrDefault(hand[i],0)+1);
        }

        while(!map.isEmpty()){
            int start = map.firstKey();
            for(int i = 0; i < groupSize; i++){
                int curr = start + i;

                if(!map.containsKey(curr)){
                    return false;
                }

                int freq = map.get(curr);
                if(freq == 1){
                    map.remove(curr);
                }
                else{
                    map.put(curr, freq-1);
                }
            }
        }

        return true;
        
    }
}
