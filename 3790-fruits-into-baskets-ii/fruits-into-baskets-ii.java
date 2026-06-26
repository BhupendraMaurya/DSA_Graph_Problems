class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int unplaced = fruits.length;
        for(int i = 0; i < fruits.length; i++){
            int j = 0;
            while(j < baskets.length){
                if(fruits[i] <= baskets[j]){
                    unplaced--;
                    baskets[j] = -1;
                    j++;
                    break;
                }
                else{
                    j++;
                }
            }
        }

        return unplaced;
    }
}