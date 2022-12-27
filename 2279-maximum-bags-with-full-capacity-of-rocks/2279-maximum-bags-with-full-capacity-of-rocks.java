class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int len = capacity.length;
        ArrayList<Integer> alist = new ArrayList<>();
        int fullBags = 0;
        for(int i = 0; i < len; i++) {
            int diff = capacity[i] - rocks[i];
            if(diff == 0) {
                fullBags++;
            } else if(diff > 0) {
                alist.add(diff);
            }
        }
        Collections.sort(alist);
        int sz = alist.size();
        
        int i = 0;
        while(i < sz && additionalRocks > 0) {
            int cap = alist.get(i);
            if(cap <= additionalRocks) {
                fullBags++;
                additionalRocks -= cap;
            }
            i++;
        }
        return fullBags;
    }
}