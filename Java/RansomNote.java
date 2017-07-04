public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote == null || ransomNote.length() == 0)  return true;
        if(magazine == null || magazine.length() == 0)  return false;
        
        HashMap<Character, Integer> dict = new HashMap<Character, Integer>();
        
        for(int i = 0; i < magazine.length(); i++){
            char c = magazine.charAt(i);
            int val = dict.containsKey(c) ? dict.get(c) : 0;
            dict.put(c,val+1);
        }
        
        for(int i = 0; i < ransomNote.length(); i++){
            char c = ransomNote.charAt(i);
            if(dict.containsKey(c) && dict.get(c) >= 1){
                dict.put(c, dict.get(c)-1);
            }
            else
                return false;
        }
        
        return true;
    }
}
