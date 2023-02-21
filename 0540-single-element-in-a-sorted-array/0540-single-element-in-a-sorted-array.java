class Solution {
    public int singleNonDuplicate(int[] nums) {
        int ans = 0;
        for(int it : nums) {
            ans ^= it;
        }
        return ans;
    }
}