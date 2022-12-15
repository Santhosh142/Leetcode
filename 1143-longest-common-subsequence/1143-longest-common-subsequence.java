class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        
        int[][] dp = new int[len1][len2];
        for(int[] ar : dp) Arrays.fill(ar, -1);
        
        return lcs(text1, text2, len1 - 1, len2 - 1, dp);
    }
    
    public int lcs(String s, String t, int ind1, int ind2, int[][] dp) {
        if(ind1 < 0 || ind2 < 0) return 0;
        
        if(dp[ind1][ind2] != -1) return dp[ind1][ind2];
        
        char ch1 = s.charAt(ind1);
        char ch2 = t.charAt(ind2);
        if(ch1 == ch2) return 1 + lcs(s, t, ind1 - 1, ind2 - 1, dp);
        
        int first = lcs(s, t, ind1 - 1, ind2, dp);
        int second = lcs(s, t, ind1, ind2 - 1, dp);
        
        return dp[ind1][ind2] = Math.max(first, second);
    }
}