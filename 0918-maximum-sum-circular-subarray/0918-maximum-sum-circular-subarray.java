class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int len = nums.length;
        int maxSum = Integer.MIN_VALUE;
        int tempMax = 0;
        
        int minSum = Integer.MAX_VALUE;
        int tempMin = 0;
        
        int arrSum = 0;
        
        for(int i = 0; i < len; i++) {
            arrSum += nums[i];
            
            tempMax += nums[i];
            maxSum = Math.max(maxSum, tempMax);
            if(tempMax < 0) {
                tempMax = 0;
            }
            
            tempMin += nums[i];
            minSum = Math.min(minSum, tempMin);
            if(tempMin > 0) {
                tempMin = 0;
            }
        }
        
        if(minSum == arrSum) {
            return maxSum;
        }
        return Math.max(maxSum, arrSum - minSum);
    }
}