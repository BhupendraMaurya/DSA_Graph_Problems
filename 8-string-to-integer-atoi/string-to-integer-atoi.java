class Solution {
    public int myAtoi(String s){
        //first check for spaces
        int i = 0;
        int n = s.length();
        if(n == 0){
            return 0;
        }
        while(i < n && s.charAt(i) == ' '){
            i++;
        }
        if(i == n){
            return 0;
        }
        int sign = 1;
        // check for signs
        if(s.charAt(i) == '-'){
            sign = -1;
            i++;
        }
        else if(s.charAt(i) == '+'){
            sign = 1;
            i++;
        }

        // check for leading zeroes;
        while(i < n && s.charAt(i) == '0'){
            i++;
        }

        StringBuilder sb = new StringBuilder();
        while(i < n && Character.isDigit(s.charAt(i))){
            sb.append(s.charAt(i));
            i++;
        }

        long ans = 0;
        for(int j = 0; j < sb.length(); j++){
            ans = ans * 10 + (sb.charAt(j) - '0');
            if(ans * sign > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            if(ans * sign < Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
            i++;
        }
        return (int)ans * sign;

    } 
}
