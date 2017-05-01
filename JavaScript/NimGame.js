/**
 * @param {number} n
 * @return {boolean}
 */
var canWinNim = function(n) {
    if(n <= 0 )  return false
    if(n%4 == 0)  return false
    else return true
};
