class Solution {
    public void generate(String map[], List<String> list, String digits, StringBuilder curr, int n){
        if(n == digits.length()){
            list.add(curr.toString());
            return;
        }
        int d = digits.charAt(n) - '0';
        for(int i = 0; i < map[d].length(); i++){
            curr.append(map[d].charAt(i));
            generate(map, list, digits, curr, n+1);
            curr.deleteCharAt(curr.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        String map[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        generate(map, result, digits, new StringBuilder(), 0);
        return result;
    }
}