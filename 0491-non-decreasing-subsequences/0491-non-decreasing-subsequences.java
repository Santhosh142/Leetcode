class Solution {
    HashSet< List<Integer> > hs;
    List<List<Integer>> res;
    public List<List<Integer>> findSubsequences(int[] nums) {
        hs = new HashSet<>();
        res = new ArrayList<>();
        List<Integer> alist = new ArrayList<>();
        
        int len = nums.length;
        solve(alist, nums, -1, 0, len);
        
        Iterator<List<Integer>> it = hs.iterator();
        while(it.hasNext()) res.add(it.next());
        
        return res;
    }
    public void solve(List<Integer> alist, int[] nums,int prev, int ind, int len) {
        if(ind == len) {
            if(alist.size() > 1) {
                hs.add(alist);
            }
            return;
        }
        if(prev == -1 || nums[ind] >= nums[prev]) {
            List<Integer> temp = new ArrayList<>(alist);
            temp.add(nums[ind]);
            solve(temp, nums ,ind, ind + 1, len);
        }
        solve(alist, nums, prev, ind + 1, len);
    }
}