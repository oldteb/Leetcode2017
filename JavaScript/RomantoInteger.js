/**
 * @param {string} s
 * @return {number}
 */
var romanToInt = function(s) {
    if(s == null || s.length == 0)
        return 0

    var map = {
        I: 1,
        V: 5,
        X: 10,
        L: 50,
        C: 100,
        D: 500,
        M: 1000
    }

    let sum = map[s[0]]
    for(let i = 1; i < s.length; i++){
        if(map[s[i]] > map[s[i-1]]){
            sum = sum - 2 * map[s[i-1]] + map[s[i]]
        }
        else{
            sum += map[s[i]]
        }
    }

    return sum

};
