class Solution {
    public int[] sortArray(int[] nums) {
        mergesort(nums, 0, nums.length - 1);
        return nums;
    }
    public void mergesort(int[] nums, int low, int high) {
        if(low < high) {
            int mid = low + (high - low) / 2;
            mergesort(nums, low, mid);
            mergesort(nums, mid + 1, high);
            conquer(nums, low , mid , high);
        }
    }
    public void conquer(int[] nums, int low, int mid, int high) {
        int n = high - low + 1;
        int[] merged = new int[n];
        int i = low, j = mid + 1, ind = 0;
        while(i <= mid && j <= high) {
            if(nums[i] < nums[j]) {
                merged[ind++] = nums[i++];
            } else {
                merged[ind++] = nums[j++];
            }
        }
        while(i <= mid) {
            merged[ind++] = nums[i++];
        }
        while(j <= high) {
            merged[ind++] = nums[j++];
        }
        for(i = low, j = 0; j < n; i++, j++) {
            nums[i] = merged[j];
        }
    }
}