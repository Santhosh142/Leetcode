class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i < n; i++) adj.add(new ArrayList<>());
        int edgLen = edges.length;
        for(int i = 0; i < edgLen; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        int res = dfs(adj, hasApple, 0, -1);
        return res;
        
    }
    public int dfs(ArrayList<ArrayList<Integer>> adj, List<Boolean> hasApple, int curr, int par) {
        int time = 0;
        for(int it : adj.get(curr)) {
            if(it == par) continue;
            int childTime = dfs(adj, hasApple, it, curr);
            
            if(childTime > 0 || hasApple.get(it)) {
                time += (2 + childTime);
            }
            
        }
        return time;
    }
}