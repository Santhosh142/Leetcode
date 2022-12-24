class Solution {
    public int numTilings(int N) {
        int mod = (int) 1e9 + 7;
        int dp[] = new int[N + 10];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        for(int i = 4 ; i <= N; i++){
            dp[i] = dp[i - 1] * 2 % mod + dp[i - 3] % mod;
            dp[i] %= mod;
        }
        return dp[N];
    }
}