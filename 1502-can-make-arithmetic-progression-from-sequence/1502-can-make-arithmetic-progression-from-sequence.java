class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int diff = arr[1] - arr[0];
        
        for(int i = 2; i < n; i++) {
            int currDiff = arr[i] - arr[i - 1];
            if(currDiff != diff) return false;
        }
        return true;
    }
}