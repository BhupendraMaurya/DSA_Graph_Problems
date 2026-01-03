class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int nums[] = new int[n1+n2];

        int i = 0;// index for nums1
        int j = 0;// pointer for nums2
        int k = 0;// pointer for nums
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] < nums2[j]){
                nums[k] = nums1[i];
                i++;
                k++;
            }
            else{
                nums[k] = nums2[j];
                k++;
                j++;
            }
        }

        while(i < nums1.length){
            nums[k] = nums1[i];
            i++;
            k++;
        }

        while(j < nums2.length){
            nums[k] = nums2[j];
            k++;
            j++;
        }

        int n = nums.length;
        double ans = -1;
        if(n % 2 != 0){
            return (double) nums[(n+1) / 2 - 1];
        }

        else{
            int a = nums[n/2 - 1];
            int b = nums[n/2];
            return (double) (a+b)/2;
        }
    }
}