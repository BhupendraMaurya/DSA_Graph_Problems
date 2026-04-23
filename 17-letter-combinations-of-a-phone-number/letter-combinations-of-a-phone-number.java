class Solution {
    public void generate(List<String> list, String map[], String digits, StringBuilder sb, int n){
        // here n is the size of the string generated till now, so if n is equal to length of original string, that means, 
        // we have got one combination, so storing it in the list. 
        if(n == digits.length()){
            list.add(sb.toString());
            return;
        }
        // here digit represents that on which index you are at currently
        int digit = digits.charAt(n) - '0';
        // with the help of above index go at this index and access that string and run loop on this,
        for(int i = 0; i < map[digit].length(); i++){
            // taking the current char and append it
            sb.append(map[digit].charAt(i));
            // recursively call the function with sizee +1 
            generate(list, map, digits, sb, n+1);
            // backtracking steps
            sb.deleteCharAt(sb.length()-1);
        } 
    }
    public List<String> letterCombinations(String digits) {
        // Using the Recursion + backtracking, 
        // Creating an array, which represents each number and then just doing the recursion. 
        // we will start from the empty string, as we dont have any string, and then we will keep taking the numbers and 
        // will try to connect this with its next combination(if exist). 
        List<String> list = new ArrayList<>();
        String map[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        generate(list, map, digits, new StringBuilder(), 0);
        return list;
    }
}