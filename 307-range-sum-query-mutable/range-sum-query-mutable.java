class NumArray {
    
    int arr[];
    int st[];
    public NumArray(int[] nums) {
        int n = nums.length;
        arr = new int[n];
        st = new int[4*n];
        for(int i = 0; i < n; i++){
            arr[i] = nums[i];
        }
        createSegmentTree(arr, 0, 0, n-1, st);
    }
    public void update(int index, int val) {
        updateST(index, 0, 0, arr.length-1, val, arr, st);
    }
    
    public int sumRange(int left, int right) {
        return sumQuery(0, 0, arr.length-1, arr, st, left, right);
    }
    public void createSegmentTree(int arr[], int i, int left, int right, int st[]){
        if(left == right){
            st[i] = arr[left];
            return;
        }
        int mid = (left + right) / 2;
        createSegmentTree(arr, 2*i + 1, left, mid, st);
        createSegmentTree(arr, 2*i + 2, mid+1, right, st);
        st[i] = st[2*i+1] + st[2*i+2];
    }
    public void updateST(int idx, int i, int left, int right, int val, int arr[], int st[]){
        if(left == right){
            st[i] = val;
            return;
        }
        int mid = (left + right) / 2;
        if(idx <= mid){
            updateST(idx, 2*i+1, left, mid, val, arr, st);
        }
        else{
            updateST(idx, 2*i+2, mid+1, right, val, arr, st);
        }
        st[i] = st[2*i+1] + st[2*i+2];
    }

    public int sumQuery(int i, int l, int r, int arr[], int st[], int start, int end){
        if(l > end || r < start){
            return 0;
        }
        if(l >= start && r <= end){
            return st[i];
        }
        int mid = (l+r)/2;
        return sumQuery(2*i+1, l, mid, arr, st, start, end) + sumQuery(2*i+2, mid+1, r, arr, st, start, end);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */