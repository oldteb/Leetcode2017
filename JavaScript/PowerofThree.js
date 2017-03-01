/**
 * @param {number} n
 * @return {boolean}
 */
var isPowerOfThree = function(n) {
    var val = Math.pow(3,20)
    return ( n>0 &&  val%n==0);
};
