class Solution {
    public int[] asteroidCollision(int[] arr) {
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > 0){
                st.push(arr[i]);
            }
            else {
                if(st.isEmpty() || st.peek() < 0){
                    st.push(arr[i]);
                }

                else if(st.peek() == Math.abs(arr[i])){
                    st.pop();
                }
                else{
                    boolean flag = false;
                    while(!st.isEmpty() && st.peek() > 0){
                        if(st.peek() < Math.abs(arr[i])){
                            st.pop();
                        }

                        else if(st.peek() == Math.abs(arr[i])){
                            st.pop();
                            flag = true;
                            break;
                            
                        }
                        else{
                            // if Abs value of current value is smaller than st.peek(), then just remove it.
                            break;
                        }
                    }

                    if(flag != true && (st.isEmpty() || st.peek() < 0 )){
                        st.push(arr[i]);
                    }
                }
            }
        }

        int len = st.size();
        int ans[] = new int[len];
        for(int i = len-1; i >= 0; i--){
            ans[i] = st.pop();
        }

        return ans;
    }
}