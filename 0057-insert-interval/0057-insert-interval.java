class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        boolean merged = false;
        int len = intervals.length;
        ArrayList<int[]> alist = new ArrayList<>();
        for(int[] ar : intervals) {
            alist.add(ar);
        }
        alist.add(newInterval);
        Collections.sort(alist, (a, b) -> a[0] - b[0]);
        int prev = 0, curr = 1;
        while(curr < alist.size()) {
            if(overlaps(alist.get(prev), alist.get(curr))) {
                int[] m = merge(alist.get(prev), alist.get(curr));
                alist.remove(curr);
                alist.remove(prev);
                alist.add(prev, m);
            }
            else {
                prev += 1;
                curr += 1;
            }
        }
        
        int[][] res = new int[alist.size()][2];
        for(int i = 0; i < alist.size(); i++) {
            res[i][0] = alist.get(i)[0];
            res[i][1] = alist.get(i)[1];
        }
        return res;
    }
    
    public int[] merge(int[] first, int[] second) {
        if(first[0] > second[0]) {
            first[0] = second[0];
        }
        if(first[1] < second[1]) {
            first[1] = second[1];
        }
        return first;
    }
    
    public boolean overlaps(int[] first, int[] second) {
        if(second[0] <= first[1]) return true;
        return false;
    }
}