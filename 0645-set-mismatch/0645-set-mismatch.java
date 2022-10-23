class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] res = new int[2];
        for(int it : nums) {
            if(nums[Math.abs(it) - 1] < 0) 
                res[0] = Math.abs(it);
            else 
                nums[Math.abs(it) - 1] *= -1;
        }
        for(int i = 0; i < n; i++) {
            if(nums[i] > 0) {
                res[1] = i + 1;
            }
        }
        return res;
        
    }
}