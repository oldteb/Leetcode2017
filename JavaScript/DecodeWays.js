/**
 * @param {string} s
 * @return {number}
 */
 // keyword: all possible ways
 // 1) DFS
 // 2) Greedy: O(n)/O(1)
var numDecodings = function(s) {
    if(s == null || s.length == 0)
        return 0

    if(s.charAt(0) == '0')  return 0

    let one = 1
    let two = 0

    for(let i = 1 ;i < s.length && one + two != 0; i++){
        let tmp = "" + s.charAt(i-1)
        tmp = tmp + s.charAt(i)
        let num = parseInt(tmp)
        let newTwo = 0
        if(num >= 10 && num <= 26){
            newTwo = one
        }

        one = s.charAt(i) == '0' ? 0 : one + two
        two = newTwo
    }

    return one + two
};
