/**
 * @param {number} n - a positive integer
 * @return {number}
 */
var hammingWeight = function(n) {
    let count = 0
    let one = 0x01
    for(let i = 0; i < 32; i++){
        count += n & one
        n >>= 1
    }

    return count
};
