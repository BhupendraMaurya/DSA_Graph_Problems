class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1 + n2;

        // I will try to solve this problem without using the extra spaces;

        /*
        * Intuition: If somehow we are able to find the elements of indexes of n/2 and n/2-1
        then my job will be done. 
        That's why taking two variables to store the indexes and also storing these elements.

        and taking one variable to store the overall current index so that we can track 
        and find our desired index. In the last, simply returning the answers, stored in 
        these variables(ele1,and ele2).

         */
        int ind1 = n / 2 - 1;
        int ind2 = n/2;
        int cnt = 0;
        int ele1 = -1;
        int ele2 = -1;

        int i = 0;
        int j = 0;
        while(i < n1 && j < n2){
            if(nums1[i] < nums2[j]){
                if(cnt == ind1) ele1 = nums1[i];
                if(cnt == ind2) ele2 = nums1[i];
                i++;
                cnt++;
            }
            else{
                if(cnt == ind1) ele1 = nums2[j];
                if(cnt == ind2) ele2 = nums2[j];
                j++;
                cnt++;
            }
        }

        while(i < n1){
            if(cnt == ind1) ele1 = nums1[i];
            if(cnt == ind2) ele2 = nums1[i];
            i++;
            cnt++;
        }

        while(j < n2){
            if(cnt == ind1) ele1 = nums2[j];
            if(cnt == ind2) ele2 = nums2[j];
            j++;
            cnt++;
        }

        if(n % 2 == 1){
            return (double) ele2;
        }

        else{
            return (double) (ele1 + ele2) / 2;
        }
    }
}