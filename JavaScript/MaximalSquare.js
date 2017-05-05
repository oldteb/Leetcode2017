/**
 * @param {character[][]} matrix
 * @return {number}
 */
 // take away:
 // DP solution:
 // let F(i,j) is the max square size start from matrix[i][j]
 // then F(i,j) = 0 , if matrix[i][j] = 0
 //             = Min(F(i+1,j), F(i,j+1), F(i+1,j+1))+1, if matrix[i][j] = 1
 // 
 // we can use the similar way to find max rectangle
var maximalSquare = function(matrix) {
    if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
        return 0

    let height = matrix.length
    let width = matrix[0].length
    let maxSize = 0

    var buf = new Array(height)
    for(let i = 0; i < height; i++){
        buf[i] = new Array(width)
    }

    for(let i = 0; i < height; i++){
        for(let j = 0; j < width; j++){
            buf[i][j] = (matrix[i][j] == "1" ? 1 : 0)
            if(buf[i][j] == 1)  maxSize = 1
        }
    }

    for(let i = height-2; i >= 0; i--){
        for(let j = width-2; j >= 0; j--){
            if(buf[i][j] == 0)
                continue
            buf[i][j] = Math.min(Math.min(buf[i+1][j], buf[i][j+1]), buf[i+1][j+1]) + 1
            maxSize = Math.max(maxSize, buf[i][j])
        }
    }

    return maxSize*maxSize

};
