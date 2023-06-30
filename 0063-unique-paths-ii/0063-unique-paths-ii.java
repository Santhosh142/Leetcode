class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        
        for(int[] ar : dp) {
            Arrays.fill(ar, -1);
        }
        
        int res = memoize(grid, dp, m - 1, n - 1);
        return res;
    }
    
    public int memoize(int[][] grid, int[][] dp, int i, int j) {
        if(i < 0 || j < 0) return 0;
        if(grid[i][j] == 1) return 0;
        if(i == 0 && j == 0) return 1;
        
        if(dp[i][j] != -1) return dp[i][j];
        int up = memoize(grid, dp, i - 1, j);
        int left = memoize(grid, dp, i, j - 1);
        return dp[i][j] = up + left;
    }
}