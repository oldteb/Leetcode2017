/**
 * @param {number[][]} matrix
 * @return {void} Do not return anything, modify matrix in-place instead.
 */
 // take away
 // 2 better variation based on my original solution:
var rotate = function(matrix) {
    if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
        return

    let rowLen = matrix.length
    let colLen = matrix[0].length

    if(rowLen == 1 && colLen == 1)
        return

    // solution 1: simplest in-place
    for(let i = 0; i < Math.floor(matrix.length / 2); i++){
        for(let j = 0; j < Math.ceil(matrix.length / 2); j++){
            let tmp = matrix[i][j]
            matrix[i][j] = matrix[rowLen-1-j][i]
            matrix[rowLen-1-j][i] = matrix[rowLen-1-i][colLen-1-j]
            matrix[rowLen-1-i][colLen-1-j] = matrix[j][colLen-1-i]
            matrix[j][colLen-1-i] = tmp
        }
    }

    // solution 2: mirror the diagonal line, and then revert up side down
    // ...

};
