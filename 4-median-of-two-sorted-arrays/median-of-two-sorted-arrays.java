class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Since I want to apply Binary Search on the smaller array, that's why, I'm just
        // checking for smaller length array and then calling the same function to reverse the arrays.
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        // Applying the BS in the smaller length array.
        int l = 0;// either taking zero elements from the first array
        int r = m;// or taking all the elements from the first array
        
        while(l <= r){
            // count of elements taken from the first array
            int px = l + (r-l)/2;

            // count of elements taken from second array
            int py = (m+n+1)/2 - px;

            // elements from the left part from both the array
            int x1 = (px == 0) ? Integer.MIN_VALUE : nums1[px-1];
            int x2 = (py == 0) ? Integer.MIN_VALUE : nums2[py-1];

            // elements from the right part after separation
            int x3 = (px == m) ? Integer.MAX_VALUE : nums1[px];
            int x4 = (py == n) ? Integer.MAX_VALUE : nums2[py];

            if(x1 <= x4 && x2 <= x3){
                if((m+n) % 2 == 1){
                    return Math.max(x1, x2);
                }

                return (double)(Math.max(x1,x2) + Math.min(x3, x4))/2;
            }

            if(x1 > x4){
                r = px - 1;
            }
            else{
                l = px + 1;
            }

        }

        return (double) -1;
        
    }
}