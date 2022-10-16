//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String A = sc.next();
                    String B = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.UncommonChars(A, B));
                }
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    String UncommonChars(String A, String B)
    {
        StringBuilder sb = new StringBuilder();
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        for(char ch : A.toCharArray()) {
            freq1[ch - 'a'] = 1;
        }
        for(char ch : B.toCharArray()) {
            freq2[ch - 'a'] = 1;
        }
        for(int i = 0; i < 26; i++) {
            if(freq1[i] == 1 && freq2[i] == 1) {
                continue;
            }
            else if(freq1[i] == 1 || freq2[i] == 1){
                sb.append((char)(i + 'a'));
            }
        }
        if(sb.length() == 0) 
            return "-1";
        return sb.toString();
    }
}