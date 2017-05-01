/**
 * @param {number} n
 * @return {number}
 */
 // Performance: all case: O(n)
var numTrees = function(n) {
    if(n <= 1) return n

    var buf = Array(n+1).fill(0)
    buf[1] = 1

    for(let i = 2; i <= n; i++){
        var tmpBuf = Array(n+1).fill(0)
        let sum = 0
        for(let j = 1; j < i; j++){
            sum += buf[j]
        }
        let top = 0
        for(let j = 1; j <= i; j++){
            tmpBuf[j] =  sum - top
            top += buf[j-1]
        }

        buf = tmpBuf
        //console.log(buf)
    }

    let rst = 0
    for(let i = 1; i <= n; i++){
        rst += buf[i]
    }

    return rst

};
