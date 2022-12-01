class Solution {
    public boolean halvesAreAlike(String s) {
        int len = s.length();
        
        Character[] vow = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        ArrayList<Character> vowels = new ArrayList<>(Arrays.asList(vow));
        
        int count = 0;
        for(int i = 0; i < len/2; i++) {
            char ch = s.charAt(i);
            if(vowels.contains(ch))
                count += 1;
        }
        for(int i = len/2; i< len; i++) {
            char ch = s.charAt(i);
            if(vowels.contains(ch))
                count -= 1;
        }
        // System.out.println(count);
        return count == 0;
        
    }
}