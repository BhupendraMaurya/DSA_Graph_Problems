class Solution {
    public void updateST(int i, int l, int r, int idx, int st[]){
        if(l == r){
            st[i] = 1;
            return;
        }
        int mid = l + (r-l)/2;
        if(idx <= mid){
            updateST(2*i+1, l, mid, idx, st);
        }
        else{
            updateST(2*i+2, mid+1, r, idx, st);
        }
        st[i] = st[2*i+1] + st[2*i+2];
    }
    public long queryST(int qs, int qe, int i, int l, int r, int st[]){
        if(l > qe || r < qs){
            return 0;
        }
        if(l >= qs && r <= qe){
            return st[i];
        }
        int mid = l + (r-l)/2;
        long left = queryST(qs, qe, 2*i+1, l, mid, st);
        long right = queryST(qs, qe, 2*i+2, mid+1, r, st);
        return left + right;
    }
    public long goodTriplets(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums1.length;
        for(int i = 0; i < nums2.length; i++){
            map.put(nums2[i], i);
        }
        // segment tree
        int st[] = new int[4*n];
        long ans = 0;

        updateST(0, 0, n-1, map.get(nums1[0]), st);
// start traversing from idx 1, because, there is no one on the left of idx 0, (if we start from idx 0).
        for(int i = 1; i < n; i++){
            int idx = map.get(nums1[i]);// indxex in nums2
            long leftCommonCount = queryST(0, idx, 0, 0, n-1, st);
            long leftNotCommonCount = i - leftCommonCount;
            long elementAfterIdxNums2 = n-1-idx;
            long rightCommonCount = elementAfterIdxNums2 - leftNotCommonCount; 
            ans += leftCommonCount * rightCommonCount;

            updateST(0, 0, n-1, idx, st);
        }
        return ans;
    }
}