package mediumHard;

public class BattleshipsinaBoard {
    public int countBattleships(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0){
        	return 0;
        }
        
        int cnt = 0;
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
            	if(board[i][j] == '.')  continue;
            	else{
            		int upCell = (i==0 || board[i-1][j]=='.') ? 0 : 1;
            		int leftCell = (j==0 || board[i][j-1]=='.') ? 0 : 1;
            		if((upCell | leftCell) == 0)  cnt++;
            	}
            }
        }
    	
    	return cnt;
    }
}
