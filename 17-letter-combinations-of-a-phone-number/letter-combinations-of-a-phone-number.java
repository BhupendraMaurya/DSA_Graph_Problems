class Solution {
    public void generate(int idx, String digits, StringBuilder sb, List<String> result, String map[]){
        if(idx == digits.length()){
            result.add(sb.toString());
            return;
        }

        int currNum = digits.charAt(idx) - '0';
        String currStr = map[currNum];
        for(int i = 0; i < currStr.length(); i++){
            sb.append(currStr.charAt(i));
            generate(idx+1, digits, sb, result, map);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        String map[] = new String[10];
        map[2] = "abc";
        map[3] = "def";
        map[4] = "ghi";
        map[5] = "jkl";
        map[6] = "mno";
        map[7] = "pqrs";
        map[8] = "tuv";
        map[9] = "wxyz";
        StringBuilder sb = new StringBuilder();
        List<String> result = new ArrayList<>();
        generate(0, digits, sb, result, map);

        return result;
    }
}