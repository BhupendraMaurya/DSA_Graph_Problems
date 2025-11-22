class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int ans[] = new int[n];
        Arrays.fill(ans, -1);

        for(int i = 0; i < n; i++){
            int j = 0;
            while(j < m){
                if(nums1[i] > nums2[j] || nums1[i] < nums2[j]){
                    j++;
                }
                else{
                    while(j < m){
                        if(nums1[i] < nums2[j]){
                            ans[i] = nums2[j];
                            break;
                        }
                        j++;
                    }
                }
                
            }
        }

        return ans;
    }
}