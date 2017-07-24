// take away:
// DP solution:
// Let F(i,j) represents the min edit distance from word1[0,i) to word2[0,j)
// then we are looking for the value of F(len(word1), len(word2))
//
// the recurrsive equation:
// F(i,j) = F(i-1,j-1)    if word1[i-1] == word2[j-1]
//        = Min{
//          F(i-1,j-1)+1    , replace word1[i-1] with word2[j-1]
//          F(i,j-1)+1      , add word2[j-1]
//          F(i-1,j)+1      , delete word1[i-1]
//          }  

public class Solution {

    public int minDistance(String word1, String word2) {
        if(word1 == null || word2 == null)  return -1;
        else if(word1.length() == 0)  return word2.length();
        else if(word2.length() == 0)  return word1.length();
        
        int[][] matrix = new int[word1.length()+1][word2.length()+1];
        
        for(int i = 0; i <= word1.length(); i++){
            for(int j = 0; j <= word2.length(); j++){
                if(i == 0)
                    matrix[i][j] = j;
                else if(j == 0)
                    matrix[i][j] = i;
                else{
                    if(word1.charAt(i-1) == word2.charAt(j-1)){
                        matrix[i][j] = matrix[i-1][j-1];
                    }
                    else{
                        int minOp = Math.min(matrix[i-1][j-1] + 1, matrix[i-1][j]+1);
                        matrix[i][j] = Math.min(minOp, matrix[i][j-1]+1);
                    }
                }
            }
        }
        
        return matrix[word1.length()][word2.length()];
        
    }
    
    
    
    
}