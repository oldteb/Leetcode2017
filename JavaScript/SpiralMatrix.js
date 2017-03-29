/**
 * @param {number[][]} matrix
 * @return {number[]}
 */
var spiralOrder = function(matrix) {
    if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
        return []

    return dfs(matrix, 0, matrix.length-1, 0, matrix[0].length-1)
};

var dfs = function(matrix, fromRow, toRow, fromCol, toCol){
    var list = []
    if(fromRow > toRow || fromCol > toCol)  return []
    if(fromRow == toRow){
        for(let i = fromCol; i <= toCol; i++)
            list.push(matrix[fromRow][i])
        return list
    }
    if(fromCol == toCol){
        for(let i = fromRow; i <= toRow; i++)
            list.push(matrix[i][fromCol])
        return list
    }

    for(let i = fromCol; i < toCol; i++){
        list.push(matrix[fromRow][i])
    }
    for(let i = fromRow; i < toRow; i++){
        list.push(matrix[i][toCol])
    }
    for(let i = toCol; i > fromCol; i--){
        list.push(matrix[toRow][i])
    }
    for(let i = toRow; i > fromRow; i--){
        list.push(matrix[i][fromCol])
    }

    var list2 = dfs(matrix, fromRow+1, toRow-1, fromCol+1, toCol-1)
    list = list.concat(list2)

    return list
};
