class Solution 
{
    public int minFlipsMonoIncr(String s) 
    {
        int len = s.length();
        int ztoOne = 0, ones = 0;
        for(int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if(ch == '0') ztoOne++;
            else ones++;
            if(ztoOne > ones) ztoOne = ones;
        }
        return ztoOne;
    }
}