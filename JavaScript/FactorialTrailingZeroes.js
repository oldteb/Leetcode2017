/**
 * @param {number} n
 * @return {number}
 */
var trailingZeroes = function(n) {
    let lvl = 5
    let cnt = 0
    while(lvl <= n){
        cnt += Math.floor(n/lvl)
        lvl *= 5
    }
    
    return cnt
};
