class Solution {
    public void generate(int i, String str, int n, List<String> list){
        // since we already had taken one char['('] in starting, that'w why going till n-1. 
        if(i == n-1){
            System.out.println(str);
            list.add(str);
            return;
        }
        // take the closing braces: ')'
        generate(i+1, str + ')', n, list);
        // taking the opening braces: '('
        generate(i+1, str + '(', n, list);
    }
    public boolean isValid(String str){
        Stack<Character> st = new Stack<>();
        int n = str.length();

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(st.isEmpty() && ch == ')'){
                return false;
            }
            else if(!st.isEmpty() && st.peek() == '(' && ch == ')'){
                st.pop();
            }
            else{
                st.push(ch);
            }
        }
        if(st.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generate(0, "(", 2 * n, list);

        List<String> ans = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            if(isValid(list.get(i))){
                ans.add(list.get(i));
            }
        }
        return ans;

    }
}