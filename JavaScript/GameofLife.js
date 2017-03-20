/**
 * @param {number[][]} board
 * @return {void} Do not return anything, modify board in-place instead.
 */
 // take away:
 // analysis:
 // 1. ask for O(1) space, consider bit manipulation

var gameOfLife = function(board) {
    if(board == null | board.length == 0 || board[0].length == 0)
        return;

    for(let i = 0; i < board.length; i++){
        for(let j = 0; j < board[0].length; j++){
            let neighbors = cntNeighbors(board, i ,j)
            if(neighbors < 2 || neighbors > 3){
                board[i][j] &= ~2
            }
            else if(neighbors == 3){
                board[i][j] |= 2
            }
            else{
                board[i][j] |= (board[i][j]%2)<<1
            }
        }
    }

    // rset value
    for(let i = 0; i < board.length; i++){
        for(let j = 0; j < board[0].length; j++){
            board[i][j] = (board[i][j]>>1)%2
        }
    }

};

var cntNeighbors = function(board, i, j){
    let cnt = 0

    cnt += (getVal(board, i-1, j-1) % 2)
    cnt += (getVal(board, i-1, j) % 2)
    cnt += (getVal(board, i-1, j+1) % 2)
    cnt += (getVal(board, i, j-1) % 2)
    cnt += (getVal(board, i, j+1) % 2)
    cnt += (getVal(board, i+1, j-1) % 2)
    cnt += (getVal(board, i+1, j) % 2)
    cnt += (getVal(board, i+1, j+1) % 2)

    return cnt
};

var getVal = function(board, i, j){
    if(i < 0 || i >= board.length)
        return 0
    if(j < 0 || j >= board[0].length)
        return 0

    return board[i][j]
}
