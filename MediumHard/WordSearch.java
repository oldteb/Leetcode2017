/* 
-- Take Away --

1. Backtracking
2. Performace
    1) outer loop: m*n
    2) inner dfs: 4 branchs per node, depth of recurssion tree is k (k == word.length()) => 4^k
    worst case: O(m*n*4^k)

3. Space
    1) O(m*n)
    2) use bit operation to optimize space to O(1)

*/

public class Solution {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0){
            return false;
        }
        boolean rst;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    if((rst = help(board,word,0,i,j)) == true)  return true;
                }
            }
        }
        return false;
    }
    
    boolean help(char[][] board, String word, int lvl, int x, int y){
        board[x][y] = (char)(board[x][y] - 32);
        if(lvl == word.length()-1)  return true;
        boolean rst;
        if(x-1 >= 0 && board[x-1][y] > 59 && board[x-1][y] == word.charAt(lvl+1))
            if((rst = help(board, word, lvl+1, x-1, y)) == true)  return true;
        if(x+1 < board.length && board[x+1][y] > 59 && board[x+1][y] == word.charAt(lvl+1))
            if((rst = help(board, word, lvl+1, x+1, y)) == true)  return true;
        if(y-1 >= 0 && board[x][y-1] > 59 && board[x][y-1] == word.charAt(lvl+1))
            if((rst = help(board, word, lvl+1, x, y-1)) == true)  return true;
        if(y+1 < board[0].length && board[x][y+1] > 59 && board[x][y+1] == word.charAt(lvl+1))
            if((rst = help(board, word, lvl+1, x, y+1)) == true)  return true;
        board[x][y] = (char)(board[x][y] + 32);
        return false;
    }
}