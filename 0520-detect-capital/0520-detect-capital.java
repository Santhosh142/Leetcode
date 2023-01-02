class Solution {
    public boolean detectCapitalUse(String word) {
        String upper = word.toUpperCase();
        String lower = word.toLowerCase();
        String capitalized = word.substring(0,1).toUpperCase() + word.substring(1).toLowerCase();
        
        if(upper.equals(word) || lower.equals(word) || capitalized.equals(word)) return true;
        return false;
        
    }
}