/**
 * @param {number} n
 * @return {string[]}
 */

var generateParenthesis = function(n) {
    if(n <= 0)  return []
    var buf = ''
    var rst = []

    buf += '('
    genParathesisRecurr(buf, 1, 0, rst, n)

    return rst
};


var genParathesisRecurr = function(buf, leftCnt, rightCnt, rst, n){

    if(buf.length == n*2){
        rst.push(JSON.parse(JSON.stringify(buf)))
        return
    }

    if(leftCnt < n){
        // buf = buf.concat('(')
        genParathesisRecurr(buf + '(', leftCnt+1, rightCnt, rst, n)
        // buf = buf.substring(0, buf.length-1)
    }

    if(leftCnt > rightCnt){
        // buf = buf.concat(')')
        genParathesisRecurr(buf + ')', leftCnt, rightCnt+1, rst, n)
        // buf = buf.substring(0, buf.length-1)
    }

};


var rst = generateParenthesis(3)
console.log(rst)
