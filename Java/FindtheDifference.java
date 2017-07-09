public class Solution {
    public char findTheDifference(String s, String t) {
        if(s == null || s.length() == 0)
            return t.charAt(0);
        
        int[] buf = new int[26];
        
        for(int i = 0; i < s.length(); i++){
            buf[s.charAt(i)-'a']++;
        }
        
        for(int i = 0; i < t.length(); i++){
            if (buf[t.charAt(i)-'a'] > 0)
                buf[t.charAt(i)-'a']--;
            else
                return t.charAt(i);
        }
        
        return t.charAt(0);
    }
}