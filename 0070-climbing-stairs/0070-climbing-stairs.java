class Solution {
    public int climbStairs(int n) {
        if(n ==  1) return 1;
        if(n == 2) return 2;
        
        int prev = 1, curr = 2;
        while(n-- > 2) {
            int sum = prev + curr;
            prev = curr;
            curr = sum;
        }
        return curr;
    }
}