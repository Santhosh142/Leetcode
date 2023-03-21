class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int len = nums.length;
        int count = 0;
        ArrayList<Integer> alist = new ArrayList<>();
        for(int i = 0; i < len; i++) {
            if(nums[i] == 0) {
                count++;
            } else {
                if(count > 0) alist.add(count);
                count = 0;
            }
        }
        if(count > 0) alist.add(count);
        long res = 0;
        for(int it : alist) {
            long sum = (long) ( (long)it * (long)(it + 1) / 2);
            res += sum;
        }
        return res;
    }
}