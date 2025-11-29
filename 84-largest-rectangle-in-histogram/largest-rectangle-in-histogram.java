class Solution {
    public int largestRectangleArea(int[] heights) {
        // Optimal Solution: Using a single pass and not calculating the NSE and PSE.
        // Simply going to each element and then calculating accordingly.

        int maxArea = 0;
        // Taking on stack and storing only rhe indexes.
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < heights.length; i++){
            // If current height is smaller than the prev, that means we have to find its PSE
            // so we have to pop the elements which are greater than current, and also if current element is 
            // smaller than the prev that means it(curr) is the NSE of its prev. 
            // So, finding the Area for the prev histogram.
            // using the formula: heights[i] * (nse - pse - 1);
            while(!st.isEmpty() && heights[st.peek()] > heights[i]){
                int element = heights[st.peek()];
                st.pop();
                int nse = i;
                int pse = st.isEmpty() ? -1 : st.peek();
                maxArea = Math.max(maxArea, element * (nse - (pse) - 1));
            }
            st.push(i);

        }

        // If there were some heights whose NSE or PSE was not available, then just take the NSE as n and pse as
        // -1 and find the area of them as well.
        int n = heights.length;
        while(!st.isEmpty()){
            int element = heights[st.peek()];
            st.pop();
            int nse = n;
            int pse = st.isEmpty() ? -1 : st.peek();
            maxArea = Math.max(maxArea, element * (nse - (pse) - 1));
        }

        return maxArea;
    }
}