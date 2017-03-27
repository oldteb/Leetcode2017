/**
 * @param {character[][]} board
 * @param {string} word
 * @return {boolean}
 */
 // take away:
 // when doinig dfs in a graph not tree, we need to mark the ancestor
 // The mark is used in three steps in recursion function:
 // 1) check if the node is a ancestor
 // 2) mark current node as an ancestor before recurse to deeper level
 // 3) unmark the current node after this level of recursion is complete

var exist = function(board, word) {
    if(board == null || board.length == 0 || board[0].length == 0 || word == null || word.length == 0)
        return false

    var marks = []
    for(let i = 0 ;i < board.length; i++){
        var list = []
        for(let j = 0; j < board[i].length; j++)
            list[j] = 0
        marks.push(list)
    }

    for(let i = 0 ;i < board.length; i++){
        for(let j = 0; j < board[i].length; j++){
            if(board[i][j] == word.charAt(0)){
                if(dfs(word, 0, board, i, j, marks))  return true
            }
        }
    }

    return false
};

var dfs = function(word, i, board, x, y, marks){
    if(i >= word.length)  return false
    if(x < 0 || x >= board.length || y < 0 || y >= board[0].length)  return false
    if(marks[x][y] == 1)  return false

    if(board[x][y] != word.charAt(i))  return false
    if(i == word.length-1)  return true
    marks[x][y] = 1

    if(dfs(word, i+1, board, x-1,y,marks))  return true
    if(dfs(word, i+1, board, x+1,y,marks))  return true
    if(dfs(word, i+1, board, x,y-1,marks))  return true
    if(dfs(word, i+1, board, x,y+1,marks))  return true

    marks[x][y] = 0
    return false
}
