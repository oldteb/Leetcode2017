/*
-- take away --

characteristic of DP solution:
    1. Find optimal: longest...
    2. transition structure of Palindrome
    
The recurrsive equation:
    Let L(i,j) be the longest palindrome sequence between from i to j inclusively
    L(i,j) = (max){
            L(i+1,j-1) + 2,  if(s[i] == s[j])  (case: when longest str includes s[i] and s[j])
            L(i,j-1),                          (case: when longest str includes s[i] but not s[j])
            L(i+1,j),                          (case: when longest str includes s[j] but not s[i])
            1,                                 (case: when substr len is 1)
    }

*/

public class Solution {
    public int longestPalindromeSubseq(String s) {
        if(s == null || s.length() == 0)
            return 0;
        
        int[][] matrix = new int[s.length()][s.length()];
        
        for(int j = 0; j < s.length(); j++){
            for(int i = j; i >= 0; i--){
                if(i == j){
                    matrix[i][j] = 1;
                }
                else{
                    int len = 0;
                    if(s.charAt(i) == s.charAt(j)){
                        len = i+1 > j-1 ? 2 : matrix[i+1][j-1]+2;
                    }
                    len = Math.max(len, matrix[i][j-1]);
                    len = Math.max(len, matrix[i+1][j]);
                    matrix[i][j] = len;
                }
            }
        }
        
        return matrix[0][s.length()-1];
    }
}