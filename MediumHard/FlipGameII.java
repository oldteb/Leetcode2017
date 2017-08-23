/*
-- Take Away --

1. calculate performace from equation
2. have clear concept of what each level of recurrsion try to do

Performance:
T(n) = (n-1) * T(n-2)
     = (n-1) * (n-3) * T(n-4)
     ...
     = (n-1) * (n-3) * (n-5)...* 1
     = O(n!!)

*/

class Solution {
    public boolean canWin(String s) {
        if(s == null || s.length() == 0)  return false;        
        return dfs(new StringBuilder(s));
    }
     
    boolean dfs(StringBuilder sb){
        for(int i = 0; i < sb.length()-1; i++){
            if(sb.charAt(i) == '+' && sb.charAt(i+1) == '+'){
                sb.setCharAt(i,'-');
                sb.setCharAt(i+1,'-');
                boolean rst = dfs(sb);
                sb.setCharAt(i,'+');
                sb.setCharAt(i+1,'+');
                if(rst == false)  return true;
            }
        }
        return false;
    }
}