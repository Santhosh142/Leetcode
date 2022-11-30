class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int it : arr) {
            map.put(it, map.getOrDefault(it, 0) + 1);
        }
        HashSet<Integer> hs = new HashSet<>();
        for(int it : map.keySet()) {
            if(hs.contains(map.get(it))) return false;
            hs.add(map.get(it));
        }
        return true;
    }
}