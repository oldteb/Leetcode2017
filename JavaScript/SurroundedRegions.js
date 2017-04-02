/**
 * @param {character[][]} board
 * @return {void} Do not return anything, modify board in-place instead.
 */
 // takw away
 // coloring problem:
 // 1.DFS: Stack overflow
 // 2.BFS: from out side to inside
 
var solve = function(board) {
    if(board == null || board.length == 0 || board[0].length == 0)
        return

    // solution 1: DFS: O(n^2)
    var map = new Map()
    for(let i = 0; i < board.length; i++){
        for(let j = 0; j < board[0].length; j++){
            if(board[i][j] == 'X' || board[i][j] == '1')
                continue
            let rst = dfs(i, j, board, 'O','1')
            if(rst == true)
                dfs(i, j, board, '1','X')
        }
    }
    for(let i = 0; i < board.length; i++){
        for(let j = 0; j < board[0].length; j++){
            if(board[i][j] == '1')
                board[i][j] = 'O'
        }
    }

    // solution 2: BFS: O(n^2) better

    return
};


var dfs = function(i, j, board, origin, mark){
    if(i < 0 || i >= board.length || j < 0 || j >= board[0].length)
        return false
    if(board[i][j] != origin)
        return true

    board[i][j] = mark

    let rst = dfs(i-1, j, board, origin, mark)
    rst &= dfs(i+1, j, board, origin, mark)
    rst &= dfs(i, j-1, board, origin, mark)
    rst &= dfs(i, j+1, board, origin, mark)

    return rst
};
