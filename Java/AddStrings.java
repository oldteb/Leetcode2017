public class Solution {
    public String addStrings(String num1, String num2) {
        if(num1 == null || num2 == null
          || num1.length() == 0 || num2.length() == 0)  return null;
        
        StringBuilder sb1 = new StringBuilder(num1).reverse();
        StringBuilder sb2 = new StringBuilder(num2).reverse();
        
        int carry = 0;
        int maxLen = Math.max(sb1.length(),sb2.length());
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < maxLen; i++){
            char c1 = i >= sb1.length() ? '0' : sb1.charAt(i);
            char c2 = i >= sb2.length() ? '0' : sb2.charAt(i);
            int tmp = (c1-'0') + (c2-'0') + carry;
            if(tmp > 9)  
                carry = 1;
            else 
                carry = 0;
            sb.append((char)((tmp%10) + '0'));
        }
        
        if(carry == 1)
            sb.append('1');
        
        return sb.reverse().toString();
        
    }
}