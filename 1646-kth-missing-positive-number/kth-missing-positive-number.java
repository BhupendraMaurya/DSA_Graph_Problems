class Solution {
    public int findKthPositive(int[] arr, int k) {
        int maxi = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < arr.length; i++){
            set.add(arr[i]);
            maxi = Math.max(maxi, arr[i]);
        }

        int count = 0;
        for(int i = 1; i <= maxi; i++){
            if(!set.contains(i) && count != k){
                count++;
                if(count == k){
                    return i;
                }
            }
            else if(!set.contains(i) && count == k){
                return i;
            }
        }

        return arr.length + k;
    }
}