class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int res = 0;
        int sum = 0;
        for(int i = 0; i < len; i++) {
            int ele = nums[i];
            sum += ele;
            int rem = sum % k;
            if(rem < 0) rem += k;
            map.put(rem, map.getOrDefault(rem, 0) + 1);
            res += map.get(rem) - 1;
        }
        return res;
    }
}