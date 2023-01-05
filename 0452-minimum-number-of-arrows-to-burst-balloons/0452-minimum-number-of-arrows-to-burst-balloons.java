class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a,b) -> Integer.compare(a[1], b[1]));
        // for(int[] ar : points)  System.out.println(Arrays.toString(ar));
        
        int len = points.length;
        int count = 1;
        int last = points[0][1];
        for(int i = 1; i < len; i++) {
            if(points[i][0] > last) {
                count++;
                last = points[i][1];
            }
        }
        return count;
    }
}