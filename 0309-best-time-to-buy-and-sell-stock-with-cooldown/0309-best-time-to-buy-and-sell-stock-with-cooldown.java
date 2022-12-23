class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][2];
        for(int[] ar : dp) Arrays.fill(ar, -1);
        
        int res = memoize(0, 1, len, prices, dp);
        return res;
    }
    public int memoize(int ind, int buy, int n, int[] prices, int[][] dp) {
        if(ind >= n) return 0;
        
        if(dp[ind][buy] != -1) return dp[ind][buy];
        
        int profit = 0;
        if(buy == 1) {
            int take = -prices[ind] + memoize(ind + 1, 0, n, prices, dp);
            int notTake = 0 + memoize(ind + 1, 1, n, prices, dp);
            profit = Math.max(profit, Math.max(take, notTake));
        } else {
            int sell = prices[ind] + memoize(ind +2, 1, n, prices, dp);
            int notSell = memoize(ind + 1, 0, n, prices, dp);
            profit = Math.max(profit, Math.max(sell, notSell));
        }
        
        return dp[ind][buy] = profit;
    }
}