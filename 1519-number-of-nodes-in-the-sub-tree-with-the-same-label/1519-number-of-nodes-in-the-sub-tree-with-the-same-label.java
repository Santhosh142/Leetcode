class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int[] edge : edges) {
            int src = edge[0];
            int dest = edge[1];
            adj.get(src).add(dest);
            adj.get(dest).add(src);
        }
        
        HashMap<Character, Integer> map = new HashMap<>();
        char[] label = labels.toCharArray();
        int[] res = new int[n];
        
        HashMap<Character, Integer> map1 = dfs(adj, label, res, 0, -1);
        return res;
        
    }
    public HashMap<Character, Integer> dfs(ArrayList<ArrayList<Integer>> adj, char[] label, int[] res, int node, int par) {
        HashMap<Character, Integer> map = new HashMap<>();
        // if(par == node) return map;
        for(int it : adj.get(node)) {
            if(it == par) 
                continue;
            HashMap<Character, Integer> map1 = dfs(adj, label, res, it, node);
            
            for(Character key : map1.keySet()) {
                if(!map.containsKey(key)) {
                    map.put(key, map1.get(key));
                }
                else {
                    int val = map.get(key);
                    map.put(key, val + map1.get(key));
                    
                }
            }
        }
        map.put(label[node], map.getOrDefault(label[node], 0) + 1);
        res[node] = map.get(label[node]);
        return map;
    }
}