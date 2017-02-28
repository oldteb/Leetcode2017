/**
 * @param {number} n
 * @return {boolean}
 */
 // take-away
 // since there is no fix type in javascript
 // result of a division will not be grounded if a remainder exists
var isHappy = function(n) {
    var set = new Set()
    set.add(n)

    while(n != 1){

        let newVal = 0
        while(n != 0){
            let digit = n%10
            newVal += digit * digit
            n = Math.floor(n/10)
        }
        n = newVal
        if(set.has(n)) return false
        else set.add(n)
    }

    return true

};
