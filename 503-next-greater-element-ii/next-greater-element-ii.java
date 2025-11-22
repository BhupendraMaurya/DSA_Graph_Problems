class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();

        for(int i = nums.length-1; i >= 0; i--){
            st.push(nums[i]);
        }

        int ans[] = new int[nums.length];
        Arrays.fill(ans, -1);

        for(int i = nums.length-1; i >= 0; i--){
            while(!st.isEmpty() && st.peek() <= nums[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                ans[i] = st.peek();
            }
            st.push(nums[i]);
        }

        return ans;
    }
}