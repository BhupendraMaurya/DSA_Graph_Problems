class Solution {

    // Generating only the correct string with the help of previous taken character(0 or 1).
    public void generateCombination(int i, String str, List<String> list, int n){
        if(i == n){
            list.add(str);
            return;
        }

        int size = str.length();
        if(i != 0 && str.charAt(size-1) == '0'){//if last taken char is '0', then we can only take '1', as we cant take adjacent zeroes.
            generateCombination(i+1, str + '1', list, n);
        }
        else{// if last char is '1', then we can take any, '0' or '1'.
            generateCombination(i+1, str + '0', list, n);
            generateCombination(i+1, str + '1', list, n);
        }

    }
    public List<String> validStrings(int n) {
        List<String> list = new ArrayList<>();
        generateCombination(0, "", list, n);
        return list;
    }
}