class Solution {
    public long countPairs(int n, int[][] edges) {
        int edgeCount = edges.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        
        
        for(int i = 0; i < edgeCount; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        boolean[] vis = new boolean[n];
        
        ArrayList<Integer> groups = new ArrayList<Integer>();
        
        for(int i = 0; i < n; i++) {
            if(vis[i] == false) {
                int noOfNodes = dfs(i, -1, vis, adj);
                groups.add(noOfNodes);
            }
        }
        long sizeOfComponent=0;
        long pairs=0;
        long remainingNodes=n;

        
        for(int i=0;i<groups.size();i++){
            sizeOfComponent=groups.get(i);
            pairs+=sizeOfComponent*(remainingNodes-sizeOfComponent);
            remainingNodes-=sizeOfComponent;
        }
        return pairs;
    }
    
    public int dfs(int node, int parent, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = true;
        int count = 1;
        
        for(int it : adj.get(node)) {
            if(it != parent && vis[it] == false) {
                count += dfs(it, node, vis, adj);
            }
        }
        return count;
    }
}