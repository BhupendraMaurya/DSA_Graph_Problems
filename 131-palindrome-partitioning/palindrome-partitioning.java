class Solution {
    public boolean isPalindrome(String s){
        int i = 0;
        int j = s.length()-1;
        while(i <= j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public void generate(int i, String s, List<List<String>> result, List<String> list){

        if(i >= s.length()){
            result.add(new ArrayList<>(list));
            return;
        }
        StringBuilder sb = new StringBuilder();
        for(int j = i; j < s.length(); j++){
            // if current substring is palindrome, then only add in list, otherwise keep adding the char in the 
            // stringbuilder. And if valid palindrome, then just take it and then recursively call the function 
            // and while backtracking, remove the last taken substring. 
            sb.append(s.charAt(j));
            if(isPalindrome(sb.toString())){
                list.add(sb.toString());
                generate(j+1, s, result, list);
                list.remove(list.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> list = new ArrayList<>();
        generate(0, s, result, list);
        return result;
    }
}