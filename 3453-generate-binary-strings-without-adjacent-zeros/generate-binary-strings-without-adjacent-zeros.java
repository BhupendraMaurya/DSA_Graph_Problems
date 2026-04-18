class Solution {
    public void generateCombination(int i, StringBuilder sb, HashSet<String> set, int n){
        if(i == n){
            set.add(sb.toString());
            return;
        }
        sb.append(0);
        generateCombination(i+1, sb, set, n);
        int m = sb.length();
        sb.deleteCharAt(m-1);
        sb.append(1);
        generateCombination(i+1, sb, set, n);
        int len = sb.length();
        sb.deleteCharAt(len-1);

    }
    public boolean hasAdjacentZeroes(String str){
        // if string has length 2
        if(str.length() == 2 && str.charAt(0) == '0' && str.charAt(0) == str.charAt(1)){
            return true;
        }
        for(int i = 1; i < str.length()-1; i++){
            char prev = str.charAt(i-1);
            char curr = str.charAt(i);
            char next = str.charAt(i+1);

            if(curr == '0' && (prev == curr || curr == next)){
                return true;
            }
        }
        return false;
    }
    public List<String> validStrings(int n) {
        HashSet<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        generateCombination(0, sb, set, n);

        List<String> list = new ArrayList<>();
        for(String str : set){
            if(hasAdjacentZeroes(str)){
                continue;
            }
            else{
                list.add(str);
            }
        }
        return list;
    }
}