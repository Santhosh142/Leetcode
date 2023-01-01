class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] ar = s.split(" ");
        int patLen = pattern.length();
        int sLen = ar.length;
        if(patLen != sLen) return false;
        Map map = new HashMap();
        for(Integer i = 0; i < sLen; i++) {
            if(map.put(pattern.charAt(i), i) != map.put(ar[i], i)) return false;
        }
        return true;
    }
}