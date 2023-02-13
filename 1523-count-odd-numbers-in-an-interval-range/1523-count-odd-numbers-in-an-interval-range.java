class Solution {
    public int countOdds(int low, int high) {
        int odds = 0;
        if(low % 2 == 0 && high % 2 == 0) odds = (high - low) / 2;
        else if(low % 2 == 0 || high % 2 == 0) odds = (high - low) / 2 + 1;
        else odds = (high - low) / 2 + 1;
        return odds;
    }
}