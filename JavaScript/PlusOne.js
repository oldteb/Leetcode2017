/**
 * @param {number[]} digits
 * @return {number[]}
 */
var plusOne = function(digits) {
    if(digits == null || digits.length == 0)
        return digits

    var newList = new Array(digits.length + 1)
    newList.forEach(function(e){
        e = 0
    })

    let carry = 1
    for(let i = digits.length-1; i >= 0; i--){
        newList[i+1] = (digits[i] + carry) % 10
        carry = Math.floor((digits[i] + carry) / 10)
    }

    if(carry == 1)
        newList[0] = 1
    else
        newList = newList.splice(1)

    return newList



};
