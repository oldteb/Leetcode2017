/**
 * @param {string} s
 * @return {number}
 */
 // takeaway
 // it is the same as decimal calculation
 // only starts from 1 not 0
var titleToNumber = function(s) {
    if(s == null || s.length == 0)
        return 0

    let lvl = 1
    let sum = 0
    for(let i = 0; i < s.length; i++){
        let c = s.charAt(s.length-1-i)
        sum += (c.charCodeAt(0) - 65 + 1) * lvl
        lvl *= 26
        // s = s.substring(0, s.length-1)
    }

    return sum
};
