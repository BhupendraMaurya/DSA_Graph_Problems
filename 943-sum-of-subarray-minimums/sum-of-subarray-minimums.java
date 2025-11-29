class Solution {
    public void nse(int arr[], int ans[]){
        Stack<Integer> st = new Stack<>();
        

        for(int i = arr.length-1; i >= 0; i--){
            // Since I'm looking for only lesser elements, thats why removing all the equal and greater elements.
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }

            if(!st.isEmpty()){
                ans[i] = st.peek();
            }
            else{
                // If no next smaller, then take size as next smller element.
                ans[i] = arr.length;
            }
            st.push(i);
        }
    }

    public void psee(int arr[], int ans[]){
        Stack<Integer> st = new Stack<>();
        

        for(int i = 0; i < arr.length; i++){
            // Since I'm looking for smaller or equal, so removing only greater elements.
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop();
            }

            if(!st.isEmpty()){
                ans[i] = st.peek();
            }
            else{
                //IF no smaller element, then just take as -1.
                ans[i] = -1;
            }
            st.push(i);
        }
    }
    
    public int sumSubarrayMins(int[] arr) {
        int sum = 0;
        int mod = (int) (1e9+7);

        int nextSmallElement[] = new int[arr.length];
        int preSmallOrEqu[] = new int[arr.length];
        nse(arr, nextSmallElement);
        psee(arr, preSmallOrEqu);

        for(int i = 0; i < arr.length; i++){
            int leftElement = i - preSmallOrEqu[i];
            int rightElement = nextSmallElement[i] - i;

            long prod = (1L * leftElement * rightElement * arr[i]) % mod;
            sum = (sum + (int)prod) % mod;

        }

        return sum;
    }
}