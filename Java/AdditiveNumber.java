import java.math.BigInteger;

public class Solution {
    public boolean isAdditiveNumber(String num) {
        if(num == null || num.length() == 0)
            return false;
        
        List<BigInteger> buf = new ArrayList<BigInteger>();
        return dfs(num, 0, buf);
        
    }
    
    boolean dfs(String num, int start, List<BigInteger> buf){
        if(start >= num.length()){
            if(buf.size() >= 3)  return true;
            else return false;
        }
        
        BigInteger newNum = null;
        
        for(int i = start; i < num.length(); i++){
            if(i-start>0 && num.charAt(start)=='0')
                return false;
            
            // consider overflow when convert string to number
            newNum = new BigInteger(num.substring(start, i+1));
            
            if(buf.size() < 2 || buf.size() >= 2 && 
               buf.get(buf.size()-2).add(buf.get(buf.size()-1)).equals(newNum)){
                buf.add(newNum);
                if(dfs(num, i+1, buf) == true)
                    return true;
                buf.remove(buf.size()-1);
            }
        } 
        
        return false; 
    }
    
    
}
