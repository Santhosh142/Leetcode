class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] first = new int[n];
        int[] second = new int[n];
        int i = 0;
        while(i < n) {
            first[i] = nums[i++];
        }
        while(i < 2 * n) {
            second[i-n] = nums[i];
            i++;
        }
        int[] res = new int[ 2 * n];
        
        i = 0;
        int j = 0, k = 0;
        while(i < 2 * n) {
            res[i++] = first[j++];
            res[i++] = second[k++];
        }
        return res;
    }
}