class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int len = rooms.size();
        boolean[] vis = new boolean[len];
        dfs(0, rooms, vis);
        for(int i = 0; i< len; i++) if(!vis[i]) return false;
        return true;
    }
    public void dfs(int src, List<List<Integer>> rooms, boolean[] vis) {
        vis[src] = true;
        for(int it : rooms.get(src)) {
            if(vis[it] == false) {
                dfs(it, rooms, vis);
            }
        }
    }
}