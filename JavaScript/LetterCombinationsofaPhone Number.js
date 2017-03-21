/**
 * @param {string} digits
 * @return {string[]}
 */
var letterCombinations = function(digits) {
    if(digits == null || digits.length == 0)
        return []

    var rst = []

    var kb = {
        2: ['a','b','c'],
        3: ['d','e','f'],
        4: ['g','h','i'],
        5: ['j','k','l'],
        6: ['m','n','o'],
        7: ['p','q','r','s'],
        8: ['t','u','v'],
        9: ['w','x','y','z']
    }

    for(let i = 0 ; i < digits.length; i++){
        let c = digits.charAt(i)
        if(c == '1' || c == '0')  continue
        if(rst.length == 0){
            rst = kb[c].concat()
            continue
        }
        var newRst = []
        for(let j = 0; j < rst.length; j++){
            var letters = rst[j]
            var tmp = []
            for(let k = 0; k < kb[c].length; k++){
                let newLetters = letters + kb[c][k]
                tmp.push(newLetters)
            }
            newRst = newRst.concat(tmp)
        }

        rst = newRst
    }

    return rst

};
