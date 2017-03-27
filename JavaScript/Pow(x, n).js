/**
 * @param {number} x
 * @param {number} n
 * @return {number}
 */
 // take away:
 // Math Implementation problem:
 // 1) understand mathmetical rules
 // 2) cosider corner cases
 // power(a,b) is a^b:
 // 4 situations to consider:
 // 1) b < 0
 // 2) b == 0
 // 3) b == 1
 // 4) b is fractional
 // The performance is O(lg(n))
var myPow = function(x, n) {
    if(n == 0)  return 1
    if(n < 0){
        x = 1/x
        n = 0 - n
    }

    if(n == 1){
        return x
    }

    let sqrt = myPow(x, Math.floor(n/2))
    let rst = sqrt * sqrt
    if(n%2 == 1)  rst *= x

    return rst
};
