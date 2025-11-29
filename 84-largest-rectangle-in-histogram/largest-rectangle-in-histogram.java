class Solution {
    public int largestRectangleArea(int[] heights) {
        // find the next smaller left, and next smaller right, and then 
        // for every index, (nxtsmaller right - next smaller left + 1)* arr[i];

        // finding the next smaller left;
        int n = heights.length;

        int leftSmall[] = new int[n];

        Stack<Integer> st = new Stack<>();
        for(int i=0;i<heights.length;i++){

            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }

            // is st is empty, that means, in heights array, no element is smaller than
            //current element, so our left boundary would be first hiehgts(means 0 index)

            if(st.isEmpty()){
                leftSmall[i] = 0;
            }
            else{
                leftSmall[i] = st.peek() + 1;
            }

            st.push(i);

        }

        st.clear();


        // finding the right smaller element

        int rightSmall[] = new int[n];

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){

                st.pop();
            }

            if(st.isEmpty()){
                rightSmall[i] = n-1;
            }

            else{
                rightSmall[i] = st.peek() -1;
            }

            st.push(i);

        }


        int maxArea = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            int area = (rightSmall[i] - leftSmall[i] + 1) * heights[i];
            maxArea = Math.max(area, maxArea);
        }

        return maxArea;
    }
}