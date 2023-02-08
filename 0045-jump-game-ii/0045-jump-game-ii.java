class Solution {
    public int jump(int[] nums) {
        int len = nums.length;
        int jmp = 0;
        int maxPos = 0;
        int currPos = 0;
        for(int i=0;i<len-1;i++) {
            maxPos = Math.max(i+nums[i],maxPos);
            if(i == currPos) {
                jmp++;
                currPos = maxPos;
            }
        }
        return jmp;
    }
}