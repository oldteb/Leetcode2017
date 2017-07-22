// take away:
// solution1: back tracking

public class Solution {
    public boolean isMatch(String s, String p) {
        if(s == null || p == null)  return false;
        else if(s.length() == 0 && p.length() == 0)  return true;
        else if(s.length() != 0 && p.length() == 0)  return false;
        
        return dfs(s,p,0,0);
    }
    
    boolean dfs(String s, String p, int idxS, int idxP){
        if(idxS == s.length() && idxP == p.length())  return true;
        else if(idxS != s.length() && idxP == p.length())  return false;
        
        if(idxP+1 == p.length() || p.charAt(idxP+1) != '*'){
            if(idxS == s.length())  return false;
            if(p.charAt(idxP) == '.' || p.charAt(idxP) == s.charAt(idxS))
                return dfs(s,p,idxS+1,idxP+1);
            else
                return false;
        }
        else{
            for(int i = idxS-1; i < s.length(); i++){
                if(i >=idxS && p.charAt(idxP) != '.' && s.charAt(i) != p.charAt(idxP))  return false;
                if(dfs(s,p,i+1,idxP+2) == true)
                    return true;
            }
            return false;
        }
    }
}