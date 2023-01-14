class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int[] parent = new int[26];
        for(int i = 0; i < 26; i++) parent[i] = i;
        
        int sLen = s1.length();
        for(int i = 0; i < sLen; i++) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            union(parent, ch1 - 'a', ch2 - 'a');
        }
        
        StringBuilder sb = new StringBuilder();
        int baseLen = baseStr.length();        
        for(int i = 0; i < baseLen; i++) {
            char ch = baseStr.charAt(i);
            char par = (char) (findParent(parent, ch - 'a') + 'a');
            sb.append(par);
            
        }
        return sb.toString();
        
        
    }
    
    public int findParent(int[] parent, int c) {
        if(parent[c] == c) return c;
        int res = findParent(parent, parent[c]);
        parent[c] = res;
        return res;
    }
    
    public void union(int[] parent, int u, int v) {
        int ux = findParent(parent, u);
        int vx = findParent(parent, v);
        
        if(ux < vx) {
            parent[vx] = ux;
        }
        else {
            parent[ux] = vx;
        }
    }
}