class Solution {
    public void buildST(int i, int l, int r, int st[], int baskets[]){
        if(l == r){
            st[i] = baskets[l];
            return;
        }
        int mid = l + (r-l)/2;
        buildST(2*i+1, l, mid, st, baskets);
        buildST(2*i+2, mid+1, r, st, baskets);
        st[i] = Math.max(st[2*i+1], st[2*i+2]);
        return;
    }
    public boolean placeFruits(int i, int l, int r, int st[], int fruitValue){
        if(st[i] < fruitValue){
            return false;
        }
        
        if(l == r){
            if(st[i] != -1){
                st[i] = -1;
                return true;
            }
            else{
                return false;
            }
            
        }
        int mid = l + (r-l)/2;
        if(st[2*i+1] >= fruitValue){
            if(placeFruits(2*i+1, l, mid, st, fruitValue)){
                st[i] = Math.max(st[2*i+1], st[2*i+2]);
                return true;
            }
        }
        else{
            if(placeFruits(2*i+2, mid+1, r, st, fruitValue)){
                st[i] = Math.max(st[2*i+1], st[2*i+2]);
                return true;
            }
        }

        return false;
    }
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int unplaced = fruits.length;
        int n = fruits.length;
        int st[] = new int[4*n];
        buildST(0, 0, n-1, st, baskets);
        for(int i = 0; i < fruits.length; i++){
            if(placeFruits(0, 0, n-1, st, fruits[i])){
                unplaced--;
            }
        }

        return unplaced;
    }
}