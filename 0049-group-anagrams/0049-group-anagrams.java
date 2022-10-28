class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if(strs == null || strs.length == 0)
            return res;
        if(strs.length == 1) {
            res.add(Arrays.asList(strs));
            return res;
        }
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for(String it : strs) {
            String signature = getSignature(it);
            if(!map.containsKey(signature)) {
                map.put(signature, new ArrayList<>());
            }
            map.get(signature).add(it);
            
        }
        for(String it : map.keySet()) {
            res.add(map.get(it));
        }
        return res;
    }
    public String getSignature(String s) {
        int len = s.length();
        int[] ar = new int[26];
        for(int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            ar[ch - 'a'] ++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; i++) {
            if(ar[i] != 0) {
                sb.append((char)('a' + i));
                sb.append(ar[i]);
            }
        }
        return sb.toString();
    }
}