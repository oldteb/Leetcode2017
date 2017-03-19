/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
 // take-away
 // the solution is a bit like the TwoSum problem
 // each time by comparing one value, we can eliminate posibility of whole area/string of numbers
 // then we know what is the next value to compare
var searchMatrix = function(matrix, target) {
    if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
        return false

    // solution 1: DFS O(mn)
    // var buf = []
    // for(let i = 0; i < matrix.length; i++){
    //     var row = []
    //     for(let j = 0; j < matrix[0].length; j++){
    //         row[j] = -1
    //     }
    //     buf[i] = row
    // }
    // return dfs(0, 0, matrix, buf, target)

    // solution 2: O(m+n)
    let r = matrix.length - 1
    let c = 0

    while(r >= 0 && c < matrix[0].length){
        if(matrix[r][c] == target){
            return true
        }
        else if(matrix[r][c] < target){
            c++
        }
        else{
            r--
        }
    }

    return false

};

var dfs = function(r, c, matrix, buf, target){
    if(r >= matrix.length || c >= matrix[0].length){
        return false
    }

    if(matrix[r][c] == target)
        return true

    if(matrix[r][c] > target){
        buf[r][c] = 0
        return false
    }

    if(buf[r][c] == 0){
        return false
    }

    if(dfs(r+1, c, matrix, buf, target) == true)
        return true

    if(dfs(r, c+1, matrix, buf, target) == true)
        return true

    buf[r][c] = 0

    return false

};
