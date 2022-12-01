class Solution {
    public int reverse(int x) {
        if(x>= Integer.MAX_VALUE || x<=Integer.MIN_VALUE) return 0;
        int i = 0;
        if(x<0){
            i = 1;
            x = -x;
        }
        long sum = 0;
        while(x>0){
            sum = sum*10+x%10;
            x/=10;
            if(sum>=Integer.MAX_VALUE) return 0;
        }
        if(i==1) sum=-sum;
        return (int)sum;
    }
}