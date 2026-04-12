class Solution {
    public int mod = 1000000007;
    public int countGoodNumbers(long n) {
        long evenpositions = (n+1)/2;
        long oddpositions = n / 2;

        long ans = (power(5, evenpositions) * power(4, oddpositions)) % mod;
        return (int)ans;
    }
    public long power(long x, long n){
        long ans = 1;
        while(n > 0){
            if(n%2 == 1){
                ans = (ans * x) % mod;
                n = n - 1;
            }
            else{
                x = (x * x) % mod;
                n = n / 2;
            }
        }
        return ans % mod;
    }
}