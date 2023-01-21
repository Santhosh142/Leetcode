class Solution {
    
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        solve(s, 0, 0, "", res);
        return res;
    }
    public void solve(String s, int i, int part, String ans, List<String> res) {
        if(i == s.length() || part == 4) {
            if(i == s.length() && part == 4) {
                res.add(ans.substring(0, ans.length() - 1));
            }
            return;
        }
        solve(s, i + 1, part + 1, ans + s.charAt(i) + ".", res);
        
        if(i + 2 <= s.length() && isValid(s.substring(i,i + 2)))
            solve(s, i + 2, part + 1, ans + s.substring(i,i + 2) + ".", res);
        
        if(i + 3 <= s.length() && isValid(s.substring(i,i + 3)))
            solve(s, i + 3, part + 1, ans + s.substring(i,i + 3) + ".", res);
    }
    public boolean isValid(String s) {
        if(s.charAt(0) == '0') return false;
        return Integer.parseInt(s) < 256;
    }
}