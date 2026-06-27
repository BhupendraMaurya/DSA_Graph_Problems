class Solution {
    public void buildST(int i, int l, int r, int segTree[], int baskets[]){
        // if range is equal, that means we have single element, so store it in the segtree.
        if(l == r){
            segTree[i] = baskets[l];
            return;
        }
        int mid = l + (r-l)/2;
        // build left and right tree.
        buildST(2*i+1, l, mid, segTree, baskets);
        buildST(2*i+2, mid+1, r, segTree, baskets);
        segTree[i] = Math.max(segTree[2*i+1], segTree[2*i+2]);
        return;
    }
    public boolean placedFruits(int i, int l, int r, int segTree[], int fruitValue){
        // if any node has value less than the fruit value, that means none of its children will have values greater than fruit value, because current node value is the maximum of its children.
        if(segTree[i] < fruitValue){
            return false;
        }
        // if we are at leaf node, that then just check whether it is alredy visited or not. 
        if(l == r){
            // if not visited previously, then just return true.
            if(segTree[i] != -1){
                segTree[i] = -1;
                return true;
            }
            // if already visited, then return false, as we cant take any already allocated basket
            else{
                return false;
            }
        }
        // now visiting left and right children.
        // since we want to take the leftmost available place, so first checking for left child if it has greater value.
        int mid = l + (r-l)/2;
        if(segTree[2*i+1] >= fruitValue){
            // check that is there any available place present on left side, and if yes, then place it and update the value of root nodes.
            if(placedFruits(2*i+1, l, mid, segTree, fruitValue)){
                segTree[i] = Math.max(segTree[2*i+1], segTree[2*i+2]);
                return true;
            }
        }
        else{// if failed to place the given fruit on the left side, then just go to the right child and check for available place.
            if(placedFruits(2*i+2, mid+1, r, segTree, fruitValue)){
                segTree[i] = Math.max(segTree[2*i+1], segTree[2*i+2]);
                return true;
            }
        }
        return false;
    }
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        // creating a segMent tree of size 4*n.
        int segTree[] = new int[4*n];
        // building a segment tree
        buildST(0, 0, n-1, segTree, baskets);
        // initially, all the fruits will be unplaced, so taking it as unplaced count,and we will keep updating it when 
        // we will be able to place any fruit successfully. 
        int unplacedFruits = fruits.length;
        for(int i = 0; i < fruits.length; i++){
            if(placedFruits(0, 0, n-1, segTree, fruits[i])){
                unplacedFruits--;
            }
        }
        return unplacedFruits;
    }
}