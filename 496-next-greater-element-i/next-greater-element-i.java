class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int ans[] = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        for(int i = m-1; i >= 0; i--){
            int curr = nums2[i];

            while(!st.isEmpty() && st.peek() <= curr){
                st.pop();
            }

            int result = st.isEmpty() ? -1 : st.peek();
            map.put(curr, result);
            st.push(curr);
        }

        for(int i = 0;i < n; i++){
            int val = map.get(nums1[i]);
            ans[i] = val;
        }
        
        return ans;
    }
}