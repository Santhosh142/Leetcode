class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        int len = tokens.length;
        
        for(int i = 0; i < len; i++) {
            String num = tokens[i];
            if(num.equals("+") || num.equals("-") || num.equals("*") || num.equals("/")) {
                
                int second = st.pop();
                int first = st.pop();
                
                if(num.equals("+")) {
                    st.push(first + second);
                } else if(num.equals("-")) {
                    st.push(first - second);
                } else if(num.equals("*")) {
                    st.push(first * second);
                } else {
                    st.push(first / second);
                }
                
            } else {
                st.push(Integer.parseInt(num));
            }
        }
        return st.pop();
    }
}