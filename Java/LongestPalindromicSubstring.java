public class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0)  return "";
        int max = Integer.MIN_VALUE;
        int idx = 0;
        for(int i = 0; i < s.length(); i++){
            int temp = subPalindromic(s,i);
            if(max < temp){
                max = temp;
                idx = i;
            }
            temp = subPalindromic(s,i,i+1);
            if(max < temp){
                max = temp;
                idx = 0-i;
            }
        }
        if(idx < 0)
            idx = (0 - idx)-(max/2-1);
        else
            idx = idx - (max-1)/2;
        return s.substring(idx,idx+max);

    }

    int subPalindromic(String s, int mid){
        int left = mid-1;
        int right = mid+1;
        int len = 1;
        while(left>=0 && right<s.length()){
            if(s.charAt(left) != s.charAt(right))  break;
            len += 2;
            left--;
            right++;
        }
        return len;
    }

    int subPalindromic(String s, int mid1, int mid2){
        int left = mid1;
        int right = mid2;
        int len = 0;
        while(left>=0 && right<s.length()){
            if(s.charAt(left) != s.charAt(right))  break;
            len += 2;
            left--;
            right++;
        }
        return len;
    }
}
