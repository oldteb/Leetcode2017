/**
 * @param {character[][]} board
 * @return {boolean}
 */
 // take away
 // javascript string can be index like arr
var isValidSudoku = function(board) {
    if(board == null || board.length == 0 || board[0].length == 0)
        return false

    let m = board.length
    let n = board[0].length

    // check rows
    for(let i = 0; i < m; i++){
        var map = new Map()
        for(let j = 0; j < n; j++){
            if(board[i][j] == '.')  continue
            if(board[i][j] < 0 || board[i][j] > 9 || map.has(board[i][j]))  return false
            else map.set(board[i][j],1)
        }
    }

    // cols
    for(let j = 0; j < n; j++){
        var map = new Map()
        for(let i = 0; i < m; i++){
            if(board[i][j] == '.')  continue
            if(board[i][j] < 0 || board[i][j] > 9 || map.has(board[i][j]))  return false
            else map.set(board[i][j],1)
        }
    }

    // check 3*3 cube
    for(let i = 0; i < m; i+=3){
        for(let j = 0; j < n ; j+=3){
            var map = new Map
            for(let x = i; x < i+3; x++){
                for(let y = j; y < j+3; y++){
                    if(board[x][y] == '.')  continue
                    if(board[x][y] < 0 || board[x][y] > 9 || map.has(board[x][y]))  return false
                    else map.set(board[x][y],1)
                }
            }
        }
    }


    return true

};
