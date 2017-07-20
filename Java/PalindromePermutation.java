// take away:
// if the string consist lower case letter only
// we use an integer to store the statistic, which is constant space

public class Solution {
    public boolean canPermutePalindrome(String s) {
        if(s == null || s.length() == 0)
            return true;
        
        Set<Character> set = new HashSet<Character>();
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(set.contains(c))
                set.remove(c);
            else
                set.add(c);
        }
        
        if(s.length()%2 == 0 && set.size() == 0)
            return true;
        else if(s.length()%2 != 0 && set.size() == 1)
            return true;
        else 
            return false;
    }
}