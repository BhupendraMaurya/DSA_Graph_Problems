class Solution {
    public long countCommas(long n) {
        long ans = 0;
        long val = 1000;
        for(int i = 1; i <= 5; i++){
            if(n >= val){
                ans += (n - val + 1);
            }
            val *= 1000;
        }
        return ans;
    }
}