public class Solution {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0)
            return s;
        
        char[] revArr = s.toCharArray();
        for(int i = 0, j = revArr.length-1; i < j; i++,j--){
            char tmp = revArr[i];
            revArr[i] = revArr[j];
            revArr[j] = tmp;
        }
        
        String revStr = String.valueOf(revArr);
        String[] strs = revStr.split("\\s+");
        
        StringBuilder sb = new StringBuilder();
        for(int i = strs.length-1; i >= 0; i--){
            if(sb.length() != 0)
                sb.append(" ");
            sb.append(strs[i]); 
        }
        
        return sb.toString();
    }
}