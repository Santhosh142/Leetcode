class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        for(int[] ar : dp) Arrays.fill(ar, -1);
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < cols; i++) {
            int ans = memoize(matrix, 0, i, rows, cols, dp);
            res = Math.min(ans, res);
        }
        return res;
    }
    public int memoize(int[][] mat, int i, int j, int rows, int cols, int[][] dp) {
        if(j < 0 || j >= cols) return Integer.MAX_VALUE;
        if(i == rows - 1) return mat[i][j];
        
        if(dp[i][j] != -1) return dp[i][j];
        int left = memoize(mat, i + 1, j - 1, rows, cols, dp);
        int right = memoize(mat, i + 1, j + 1, rows, cols, dp);
        int down = memoize(mat, i + 1, j, rows, cols, dp);
        
        return dp[i][j] = mat[i][j] + Math.min(left, Math.min(right, down));
    }
}