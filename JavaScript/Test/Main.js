/**
 * @param {number} n
 * @return {number}
 */
var numSquares = function(n) {
    if(n == 0)
        return 0

    var buf = []
    for(let i = 0; i <= n; i++){
        buf[i] = Math.MAX_SAFE_INTEGER
    }

    for(let i = 1; i*i <= n; i++){
        buf[i*i] = 1
    }
    buf[0] = 0

    for(let i = 1; i <= n; i++){
        for(let j = 1; j*j <= i; j++){
            buf[i] = Math.min(buf[i - j*j] + 1, buf[i])
        }
    }

    return buf[n]
};

numSquares(2)
