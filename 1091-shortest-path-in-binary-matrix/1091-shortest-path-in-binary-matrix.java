class Pair{
    int row;
    int col;
    int dist;
    Pair(int row,int col,int dist){
        this.row=row;
        this.col=col;
        this.dist=dist;
    }
}//Pair

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        return bfs(grid);
        
    }
    
    int bfs(int[][] grid){
        
        int RowDir[]={-1,-1,0,1,1,1,0,-1};
        int ColDir[]={0,1,1,1,0,-1,-1,-1};
        int m=grid.length;
        int n=grid[0].length;
        boolean visited[][]=new boolean[m][n];
        Queue<Pair> q=new LinkedList<>();
        
        if(grid[0][0]==1)
                  return -1;
        
        q.add(new Pair(0,0,1));
        
        int Ans=Integer.MAX_VALUE;

        while(!q.isEmpty()){
             Pair rem=q.poll();
             if(rem.row==m-1 && rem.col==n-1){
                    Ans=rem.dist;
                    break;
             }


             for(int i=0;i<8;i++){
               int c_row=RowDir[i]+rem.row;
               int c_col=ColDir[i]+rem.col;
               if(c_row>=0 && c_row<m && c_col>=0 && c_col<n && visited[c_row][c_col]==false && grid[c_row][c_col]!=1){
                   q.add(new Pair(c_row,c_col,rem.dist+1));
                   visited[c_row][c_col]=true;
               }
             }//8 directions ....
        }//q
         return (Ans==Integer.MAX_VALUE)?-1:Ans;
    }//bfs...
}