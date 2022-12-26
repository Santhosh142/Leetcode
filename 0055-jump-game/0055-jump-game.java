class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int maxPos = 0;
        for(int i=0;i<len-1;i++) {
            maxPos = Math.max(maxPos,i+nums[i]);
            if(maxPos <= i) return false;
        }
        return true;
    }
}