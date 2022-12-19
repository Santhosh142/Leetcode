class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n ;i++) adj.add(new ArrayList<>());
        int len = edges.length;
        for(int[] ar : edges) {
            int s = ar[0];
            int d = ar[1];
            adj.get(s).add(d);
            adj.get(d).add(s);
        }
        boolean[] vis = new boolean[n];
        dfs(source, adj, vis);
        return vis[destination];
    }
    public void dfs(int src, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[src] = true;
        for(int it : adj.get(src)) {
            if(vis[it] == false) {
                dfs(it, adj, vis);
            }
        }
    }
}