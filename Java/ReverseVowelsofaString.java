public class Solution {
    public String reverseVowels(String s) {
        if(s == null || s.length() == 0)
            return s;
        
        List<Integer> buf = new ArrayList<Integer>();
        for(int i = 0; i < s.length(); i++)
            if(isVowels(s.charAt(i)) == true)
                buf.add(i);
        
        int i = 0;
        int j = buf.size()-1;
        
        StringBuilder sb = new StringBuilder(s);
        
        while(i < j){
            swap(sb,buf.get(i++), buf.get(j--));
        }
        
        return sb.toString();
        
    }
    
    boolean isVowels(char c){
        if(c == 'a' || c == 'A'
          || c == 'e' || c == 'E'
          || c == 'i' || c == 'I'
          || c == 'o' || c == 'O'
          || c == 'u' || c == 'U')
            return true;
        else
            return false;
    }
    
    void swap(StringBuilder sb, int left, int right){
        char c = sb.charAt(right);
        sb.setCharAt(right, sb.charAt(left));
        sb.setCharAt(left, c);
    }
}
