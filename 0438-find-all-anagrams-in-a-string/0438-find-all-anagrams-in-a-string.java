class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int pLen = p.length();
        int sLen = s.length();
        
        if(sLen < pLen) return res;
        
        int[] pFreq = new int[26];
        for(int i = 0; i < pLen; i++) {
            char ch = p.charAt(i);
            pFreq[ch - 'a']++;
        }
        
        int[] sFreq = new int[26];
        int i = 0;
        while(i < pLen) {
            char ch = s.charAt(i);
            sFreq[ch - 'a']++;
            i++;
        }
        
        int j = 0;
        
        if(Arrays.equals(pFreq, sFreq)) {
            res.add(j);
        }
        
        while(i < sLen) {
            sFreq[s.charAt(i++) - 'a']++;
            sFreq[s.charAt(j++) - 'a']--;
            
            if(Arrays.equals(pFreq, sFreq)) {
                res.add(j);
            }
        }
        return res;
    }
}