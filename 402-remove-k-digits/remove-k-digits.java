class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length() == k){
            return "0";
        }
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < num.length(); i++){
            int val = num.charAt(i) - '0';
            while(!st.isEmpty() && st.peek() > val && k > 0){
                st.pop();
                k--;
            }

            st.push(val);
            
        }

        
        while(k > 0){
            st.pop();
            k--;
        }
        if(st.isEmpty()){
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }

        while(sb.length() > 0 && sb.charAt(sb.length()-1) == '0'){
            sb.deleteCharAt(sb.length()-1);
        }

        sb.reverse();

        return sb.length() == 0 ? "0" : sb.toString();
    }
}