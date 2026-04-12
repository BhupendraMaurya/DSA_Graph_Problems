class Solution {
    public int mod = 1000000007;
    public int countGoodNumbers(long n) {
        long evenpositions = (n+1)/2;
        long oddpositions = n / 2;

        long ans = (power(5, evenpositions) * power(4, oddpositions)) % mod;
        return (int)ans;
    }
    public long power(long x, long n){
        if(n == 0){
            return 1;
        }

        long half = power(x, n/2);
        long result = (half * half) % mod;
        if(n % 2 == 1){
            result = result * x;
        }
        return result % mod;
    }
}