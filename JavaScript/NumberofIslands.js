/**
 * @param {character[][]} grid
 * @return {number}
 */
 // take away:
 // it is a count/search problem, consider:
 // 1. DFS/BFS
 // 2. data structure
 // 3. DP
var numIslands = function(grid) {
    if(grid == 0 || grid.length == 0 || grid[0].length == 0)
        return 0

    let islands = 0
    let m = grid.length
    let n = grid[0].length

    // solution 1: DFS O(mn)
    for(let i = 0; i < m; i++){
        for(let j = 0; j < n; j++){
            if(grid[i][j] == '1'){
                dfs(grid, i, j, m, n)
                islands++
            }
        }
    }

    //solution 2: BFS

    return islands
};

var dfs = function(grid, i, j, m, n){
    if(i < 0 || i >= m || j < 0 || j >= n)
        return

    if(grid[i][j] == '0')  return
    if(grid[i][j] == '1')
        grid[i][j] = '0'

    dfs(grid, i-1, j, m, n)
    dfs(grid, i, j+1, m, n)
    dfs(grid, i+1, j, m, n)
    dfs(grid, i, j-1, m, n)

    return
}
