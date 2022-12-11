class Solution {
    public long[] sumOfThree(long num) {
        long x = num/3;
        if(num % 3 != 0) return new long[0];
        return new long[]{x-1, x, x + 1};
    }
}