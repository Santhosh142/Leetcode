class Solution {
    public int minPathSum(int[][] grid) 
    {
        int rows = grid.length;            
        int cols = grid[0].length;
        
        int[][] dp = new int[rows][cols];
        for(int i=0;i<rows;i++) for(int j=0;j<cols;j++) dp[i][j] = -1;
        return solve(grid,rows-1,cols-1,dp);
    } 
    public int solve(int[][] grid,int rows,int cols,int[][] dp)
    {
        if(rows < 0 || cols < 0)
            return Integer.MAX_VALUE;
        if(rows == 0 && cols ==0)
            return grid[rows][cols];
        if(dp[rows][cols] != -1)
            return dp[rows][cols];
        
        int up = solve(grid,rows-1,cols,dp);
        int left = solve(grid,rows,cols-1,dp);
        
        return dp[rows][cols] = grid[rows][cols] + Math.min(up,left);
    }
    
}