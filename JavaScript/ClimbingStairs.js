/**
 * @param {number} n
 * @return {number}
 */
var climbStairs = function(n) {
    // solution 1: DP
    // let ss = 1  // single step array
    // let ds = 0  // double step array
    // for(let i = n-2; i >= 0;i--){
    //     let newSS = ss + ds
    //     let newDS = ss
    //     ss = newSS
    //     ds = newDS
    // }
    // return ss + ds

    // solution 2: DFS
    var map = new Map()
    return climb(0,n,map)


};

var climb = function(x, n, map){
    if(x == n)  return 1
    else if(x > n) return 0

    if(map.has(x)) return map.get(x)

    let steps = climb(x+1,n,map) + climb(x+2,n,map)
    map.set(x, steps)
    return steps
}
