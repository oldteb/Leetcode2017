/**
 * @param {number[][]} matrix
 * @return {void} Do not return anything, modify matrix in-place instead.
 */
 // take away
 // For O(1) space requirement, consider:
 // 1. Bit manipulation
 // 2. store info in place
 // 3. Recursion
var setZeroes = function(matrix) {
    if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
        return matrix

    // solution 1: O(mn)
    // solution 2: O(m+n)
    // solution 3: O(min(m,n))
    // solution 4: O(1)
    let col0 = 1
    let m = matrix.length
    let n = matrix[0].length
    for(let i = 0; i < m; i++){
        if(matrix[i][0] == 0)  col0 = 0
        for(let j = 1; j < n; j++){
            if(matrix[i][j] == 0){
                matrix[0][j] = 0
                matrix[i][0] = 0
            }
        }
    }

    for(let i = 1; i < m; i++){
        for(let j = 1; j < n; j++){
            if(matrix[0][j] == 0 || matrix[i][0] == 0){
                matrix[i][j] = 0
            }
        }
    }

    if(matrix[0][0] == 0){
        for(let j = 0; j < n; j++)
            matrix[0][j] = 0
    }

    if(col0 == 0){
        for(let i = 0; i < m; i++)
            matrix[i][0] = 0
    }

    return

};
