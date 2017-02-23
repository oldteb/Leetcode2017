/**
 * @param {number} a
 * @param {number} b
 * @return {number}
 */
 // takeaway
 // the essense of carry is addition
var getSum = function(a, b) {
    let sum = a

    while(b != 0){
        let temp = sum ^ b
        b = (sum & b)<<1
        sum = temp
    }

    return sum
};
