class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 0);
        return memoize(dp, n);
    }
    
    public int memoize(int[] dp, int n) {
        if(n == 0 || n == 1) return 1;
        
        if(dp[n] != 0) return dp[n];
        
        return dp[n] = memoize(dp, n - 1) + memoize(dp, n - 2);
    }
}