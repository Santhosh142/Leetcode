class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int ind = 0;
        int n = costs.length;
        
        int count = 0;
        
        while(coins > 0 && ind < n) {
            if(costs[ind] > coins) break;
            
            coins -= costs[ind];
            count++;            
            ind++;
        }
        return count;
    }
}