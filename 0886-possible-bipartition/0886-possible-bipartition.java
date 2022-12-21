class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] ar : dislikes) {
            int src = ar[0];
            int dest = ar[1];
            adj.get(src).add(dest);
            adj.get(dest).add(src);
        }
        int[] vis = new int[n + 1];
        Arrays.fill(vis, -1);
        
        boolean res = true;
        for(int i = 1; i <= n; i++) {
            if(vis[i] == -1) {
                boolean ans = bfs(i, vis, adj);
                res &= ans;
            }
        }
        return res;
    }
    
    public boolean bfs(int node, int[] vis, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = 1;
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        while(!q.isEmpty()) {
            int temp = q.poll();
            for(int it : adj.get(temp)) {
                if(vis[it] == -1) {
                    vis[it] = 1- vis[temp];
                    q.offer(it);
                } else if(vis[it] == vis[temp]) {
                    return false;
                }
            }
        }
        return true;
    }
    
}