class Solution {
    public int maxDistance(String moves) {
        // since we know that two moves(upper and right will increase the sum and moves(down and left) will decrease the sum. So we will keep doing the operations for eeach move and for '_', we will simply add 1 as we can take character. So will always increase the sum by taking 1. 

        int x = 0;
        int y = 0;
        int udrscore = 0;
        for(int i = 0; i < moves.length(); i++){
            char ch = moves.charAt(i);
            if(ch == 'U') y++;
            else if(ch == 'R') x++;
            else if(ch == 'D')y--;
            else if(ch == 'L')x--;
            else{
                udrscore++;
            }
        }
        return Math.abs(x) + Math.abs(y) + udrscore;
    }
}