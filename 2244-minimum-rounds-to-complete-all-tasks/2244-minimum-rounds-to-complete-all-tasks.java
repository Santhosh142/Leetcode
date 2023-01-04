class Solution {
    public int minimumRounds(int[] tasks) {
        int tasksLen = tasks.length;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int it : tasks) map.put(it, map.getOrDefault(it, 0) + 1);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int key : map.keySet()) {
            pq.offer(map.get(key));
        }
        
        int minRounds = 0;
        
        while(!pq.isEmpty() && pq.peek() > 1) {
            int item = pq.poll();
            if(item >= 2) {
                if(item % 3 == 0) item -= 3;
                else item -= 2;
            }
            
            if(item > 0) {
                pq.offer(item);
            }
            minRounds++;
        }
        
        if(!pq.isEmpty()) return -1;
        return minRounds;
    }
}