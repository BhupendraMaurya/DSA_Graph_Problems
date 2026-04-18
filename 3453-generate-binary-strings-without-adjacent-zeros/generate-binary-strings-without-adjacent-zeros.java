class Solution {

    // Generate all the combinations of size n, and then check binary strings has adjacent zeroes and which not.
    public void generateCombination(int i, String str, HashSet<String> set, int n){
        if(i == n){
            set.add(str);
            return;
        }
        generateCombination(i+1, str + '0', set, n);

        generateCombination(i+1, str + '1', set, n);

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
        generateCombination(0, "", set, n);

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