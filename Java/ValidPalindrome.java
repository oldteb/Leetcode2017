public class Solution {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0)
            return true;

        String cleanStr = s.replaceAll("[^a-zA-Z0-9]","");
        cleanStr = cleanStr.toLowerCase();

        int left = 0;
        int right = cleanStr.length() - 1;
        while(left < right){
            if(cleanStr.charAt(left) != cleanStr.charAt(right)){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
