class Pair {
    int i;
    int j;
    Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
}


class Solution {
    public int numEnclaves(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        
        boolean[][] vis = new boolean[rows][cols];
        
        for(int i = 0; i < rows; i++) {
            if(grid[i][0] == 1) {
                Pair p = new Pair(i, 0);
                q.offer(p);
            }
            if(grid[i][cols - 1] == 1) {
                Pair p = new Pair(i, cols - 1);
                q.offer(p);
            }
        }
        
        for(int i = 1; i < cols - 1; i++) {
            if(grid[0][i] == 1) {
                Pair p = new Pair(0, i);
                q.offer(p);
            }
            if(grid[rows - 1][i] == 1) {
                Pair p = new Pair(rows - 1, i);
                q.offer(p);
            }
        }
        
        while(!q.isEmpty()) {
            Pair p = q.poll();
            int i = p.i, j = p.j;
            if(vis[i][j] == false) {
                dfs(grid, vis, i, j, rows, cols);
            }
        }
        
        int count = 0;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j ++) {
                if(grid[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }
    
    public void dfs(int[][] grid, boolean[][] vis, int i, int j, int rows, int cols) {
        if(i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] == 0 || vis[i][j] == true) {
            return;
        }
        grid[i][j] = 0;
        vis[i][j] = true;
        dfs(grid, vis, i + 1, j, rows, cols);
        dfs(grid, vis, i - 1, j, rows, cols);
        dfs(grid, vis, i, j - 1, rows, cols);
        dfs(grid, vis, i, j + 1, rows, cols);
    }
}