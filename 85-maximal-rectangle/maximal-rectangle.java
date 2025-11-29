class Solution {
    public int singleRectangle(int heights[]){
        int n = heights.length;

        int leftSmall[] = new int[n];

        Stack<Integer> st = new Stack<>();

        
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }

            if(st.isEmpty()){
                leftSmall[i] = 0;
            }
            else{
                leftSmall[i] = st.peek() + 1;
            }

            st.push(i);
        }

        st.clear();

        int rightSmall[] = new int[n];

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }

            if(st.isEmpty()){
                rightSmall[i] = n-1;
            }
            else{
                rightSmall[i] = st.peek() - 1;
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
    public int maximalRectangle(char[][] matrix) {
        

        int n = matrix.length;
        int m = matrix[0].length;

        int a[][] = new int[n][m];

        int arr[] = new int[m];

        // converting char values in int, and storing them in a array
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                a[i][j] = matrix[i][j] - '0';
            }
        }

        int maxRectangleArea = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
 
                // filling given array 
                if(a[i][j] == 0){
                    arr[j] = 0;
                    
                }

                else{
                    arr[j] = arr[j] + 1;
                    
                }
            }

            // finding the area
            int area = singleRectangle(arr);
            maxRectangleArea = Math.max(maxRectangleArea,area);
        }

        return maxRectangleArea;
    }
}