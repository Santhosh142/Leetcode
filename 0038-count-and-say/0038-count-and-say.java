class Solution {
    public String countAndSay(int n) {
        return solve(n, "1");
        
    
    }
    public String solve(int n, String res) {
        if(n == 1)
            return res;
        
        int len = res.length();
        int prev = 0;
        int next = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < len; i++) {
            if(res.charAt(i) == res.charAt(i - 1)) {
                next++;
            }
            else {
                String sub = res.substring(prev, next + 1);
                sb.append(sub.length());
                sb.append(sub.charAt(0));
                prev = i;
                next = i;
            }
        }
        String sub = res.substring(prev, next + 1);
        sb.append(sub.length());
        sb.append(sub.charAt(0));
        
        return solve(n - 1, sb.toString());
        
    }
}