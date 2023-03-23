class Solution {
    public int makeConnected(int n, int[][] connections) 
    {
        int m = connections.length;
        if(m < n-1) return -1;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<Integer>());
        
        for(int[] ar : connections)
        {
            adj.get(ar[0]).add(ar[1]);
            adj.get(ar[1]).add(ar[0]);
        }
        boolean[] vis = new boolean[n];
        
        int count = 0;
        for(int i=0;i<n;i++)
        {
            if(vis[i] == false)
            {
                dfs(i,adj,vis);
                count++;
            }
        }
        return count-1;
    }
    public static void dfs(int node,ArrayList<ArrayList<Integer>> adj,boolean[] vis)
    {
        vis[node] = true;
        for(int it : adj.get(node))
        {
            if(vis[it] == false)
                dfs(it,adj,vis);
        }
    }
}