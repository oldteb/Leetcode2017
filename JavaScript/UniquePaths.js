/**
 * @param {number} m
 * @param {number} n
 * @return {number}
 */
var uniquePaths = function(m, n) {
    if(m <= 0 || n <= 0)
        return 0

    // solution 1: too slow
    // return dfs(0, 0, m, n, 0)

    // solution 2
    var buf = []
    for(let i = 0; i < n; i++)
        buf[i] = 1

    for(let i = 1 ; i < m; i++){
        for(let j = 1; j < n; j++){
            buf[j] = buf[j] + buf[j-1]
        }
    }

    return buf[n-1]

};

var dfs = function(row, col, m, n, cnt){
    if(row >= m || col >= n){
        return cnt
    }

    if(row == m-1 && col == n-1){
        return ++cnt
    }

    cnt = dfs(row+1, col, m, n, cnt)
    cnt = dfs(row, col+1, m, n, cnt)

    return cnt
}
