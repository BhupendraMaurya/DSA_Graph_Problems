class Solution {
    public void generate(int i, String str, int n, List<String> list, int open, int close){
        if(i == 2 * n){
            System.out.println(str);
            list.add(str);
            return;
        }

        if(open < n){
            // taking the opening braces: '('
            generate(i+1, str + '(', n, list, open + 1, close);
        }
        if(close < open){
            // generate(i+1, str + '(', n, list, open + 1, close);
            generate(i+1, str + ')', n, list, open, close + 1);
        }

    }
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generate(0, "", n, list, 0, 0);
        return list;

    }
}