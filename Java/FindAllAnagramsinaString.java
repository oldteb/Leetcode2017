public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> rst = new ArrayList<Integer>();
        if(s == null || s.length() == 0
            || p == null || p.length() == 0)
                return rst;

        int[] sig = new int[26];
        int[] cur = new int[26];
        
        for(int i = 0; i < p.length(); i++){
            sig[p.charAt(i)-'a']++;
        }
        
        for(int i = 0; i < s.length() && i < p.length()-1; i++){
            cur[s.charAt(i)-'a']++;
        }
        
        
        for(int i = p.length()-1; i < s.length(); i++){
            cur[s.charAt(i)-'a']++;

            int isEqual = 1;
            for(int j = 0; j < 26; j++){
                if(sig[j] != cur[j]){
                    isEqual = -1;
                    break;
                }
            }

            if(isEqual == 1)
                rst.add(i-p.length()+1);

            cur[s.charAt(i-p.length()+1)-'a']--;  
        }
        
        return rst;
        
        
    }
}