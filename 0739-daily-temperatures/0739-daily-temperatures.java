class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int len = temperatures.length;
        int[] res = new int[len];
        for(int i = 0; i < len; i++) {
            
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                res[stack.pop()] = i;
            }
            stack.push(i);
            
        }
        for(int i = 0; i < len; i++) {
            if(res[i] > 0)
            res[i] = res[i] - i;
        }
        return res;
    }
}