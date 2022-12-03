

class Solution {
    public String frequencySort(String s) {
        int len = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> b.val - a.val);
        for(char ch : map.keySet()) {
            Pair pair = new Pair(ch, map.get(ch));
            pq.add(pair);
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            Pair p = pq.poll();
            char ch = p.key;
            int val = p.val;
            while(val-- > 0) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
    
    public class Pair {
        char key;
        int val;
        Pair(char key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}