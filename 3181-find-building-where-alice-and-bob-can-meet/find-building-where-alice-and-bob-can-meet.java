class Solution {
    // In this problem, segTree will store the indexes of the elements which are the maximum in their range.
    // like if from index 2-5, if idx 3 has the maximum value, then will store this value in the segtree in that range.
    public void createRMIQSegtree(int heights[], int i, int l, int r, int segTree[]){
       if(l == r){
        segTree[i] = l;
        return;
       } 
       int mid = l + (r-l)/2;

       createRMIQSegtree(heights, 2*i+1, l, mid, segTree);
       createRMIQSegtree(heights, 2*i+2, mid+1, r, segTree);

       int leftMaxIdx = segTree[2*i+1];
       int rightMaxIdx = segTree[2*i+2];

       if(heights[leftMaxIdx] > heights[rightMaxIdx]){
        segTree[i] = leftMaxIdx;
       }
       else{
        segTree[i] = rightMaxIdx;
       }
       return;
    }
    public int queryRMIQ(int i, int l, int r, int start, int end, int heights[], int segTree[]){
        if(l > end || r < start){
            return -1;
        }
        if(l >= start && r <= end){
            return segTree[i];
        }
        int mid = l + (r-l)/2;
        int leftMaxIdx = queryRMIQ(2*i+1, l, mid, start, end, heights, segTree);
        int rightMaxIdx = queryRMIQ(2*i+2, mid+1, r, start, end, heights, segTree);
        if(leftMaxIdx == -1){
            return rightMaxIdx;
        }
        if(rightMaxIdx == -1){
            return leftMaxIdx;
        }
        if(heights[leftMaxIdx] > heights[rightMaxIdx]){
            return leftMaxIdx;
        }
        else{
            return rightMaxIdx;
        }
    }
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length;
        int segTree[] = new int[4 * n];
        createRMIQSegtree(heights, 0, 0, n-1, segTree);
        
        // now finding the index of the building where Alice and bob will meet(if possible).
        int ans[] = new int[queries.length];
        // Arrays.fill(ans, -1);
        for(int i = 0; i < ans.length; i++){
            int q1 = queries[i][0];
            int q2 = queries[i][1];
            int minIdx = Math.min(q1, q2);
            int maxIdx = Math.max(q1, q2);
            if(q1 == q2){// if they are on the same building, then dont do anything.
                ans[i] = q1;
            }
            else if(heights[maxIdx] > heights[minIdx]){// if max idx building has greater ht, then store its idx.
                ans[i] = maxIdx;
            }
            else{// else do the Binary search(first search on left side and then on right if not found.);
                int start = maxIdx+1;
                int end = n-1;
                // int full_range = queryRMIQ(0, 0, n-1, start, end, heights, segTree);
                int resultIdx = n;
                while(start <= end){
                    int mid = start + (end - start)/2;
                    int idx = queryRMIQ(0, 0, n-1, start, mid, heights, segTree);

                    if(idx != -1 && heights[idx] > Math.max(heights[minIdx], heights[maxIdx])){
                        resultIdx = Math.min(resultIdx, idx);
                        end = mid-1;
                    }
                    else{
                        start = mid + 1;
                    }
                }
                ans[i] = resultIdx == n ? -1 : resultIdx;
            }
        }
        return ans;
    }
}