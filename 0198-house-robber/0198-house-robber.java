class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, -1);
        return robMoney(nums, len - 1, dp);
    }
    public int robMoney(int[] nums, int ind, int[] dp) {
        if(ind < 0) return 0;
        
        if(dp[ind] != -1) return dp[ind];
        
        int pick = nums[ind] + robMoney(nums, ind - 2, dp);
        int notPick = robMoney(nums, ind - 1, dp);
        
        return dp[ind] = Math.max(pick, notPick);
    }
}