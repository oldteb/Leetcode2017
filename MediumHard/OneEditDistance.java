class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if(s == null || t == null)  return false;
        if(Math.abs(s.length() - t.length()) > 1)  return false;
         
        String shortStr = s.length() > t.length() ? t : s;
        String longStr = s.length() > t.length() ? s : t;
        
        int i = 0;
        boolean hasEdit = false;
        while(i < shortStr.length()){
            if(shortStr.charAt(i) == longStr.charAt(i)){}
            else if(hasEdit == false){
                if(shortStr.length() != longStr.length()){
                    shortStr = shortStr.substring(0, i) + String.valueOf(longStr.charAt(i)) + shortStr.substring(i);
                }
                hasEdit = true;
            }
            else
                return false;
            i++;
        }
        if(i < longStr.length())  return hasEdit == true ? false : true;

        return hasEdit == true ? true : false;
    }
}