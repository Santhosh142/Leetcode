class Solution {
    public int minDeletionSize(String[] strs) {
        int sLen = strs[0].length();
        int strsLen = strs.length;
        
        int count = 0;
        for(int i = 0; i < sLen; i++) {
            for(int j = 1; j < strsLen; j++) {
                String second = strs[j];
                String first = strs[j - 1];
                if(second.charAt(i) - first.charAt(i) < 0) {
                    count++;
                    break;
                }
            }
        }
        return count;
        
    }
}