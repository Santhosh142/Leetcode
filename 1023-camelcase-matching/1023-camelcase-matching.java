class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList<>();
        int qLen = queries.length;
        int patLen = pattern.length();
        for(int i = 0; i < qLen; i++) {
            String s = queries[i];
            int sLen = s.length();
            int pPtr = 0, sPtr = 0;
            boolean flag = true;
            while(pPtr < patLen && sPtr < sLen) {
                if(pattern.charAt(pPtr) == s.charAt(sPtr)) {
                    sPtr++; pPtr++;
                } else {
                    if(s.charAt(sPtr) < 'a') {
                        // System.out.println(s.charAt(i))
                        flag = false;
                        break;
                    }
                    sPtr++;
                }
            }
            if(pPtr < patLen) {
                flag = false;
            }
            else {
                while(sPtr < sLen) {
                    if(s.charAt(sPtr) < 'a') {
                        flag = false;
                        break;
                    }
                    sPtr++;
                }
            }
            res.add(flag);
            
            
        }
        return res;
    }
}