/**
 * @param {string} s
 * @return {string}
 */
var reverseString = function(s) {
    if(s == null || s.length == 0)
        return s

    // solution 1
    // String.prototype.splice = function(idx, rem, str) {
    //     return this.slice(0, idx) + str + this.slice(idx + Math.abs(rem));
    // };
    //
    // let len = s.length
    // let i = 0
    // while(i < Math.floor(len/2)){
    //     let c = s.charAt(len-1-i)
    //     s = s.splice(len-1-i,1,s.charAt(i))
    //     s = s.splice(i, 1, c)
    //     i++
    // }

    // return s

    // solution 2
    // let stack = new Array()
    // let rst = ''
    // let i = 0
    // while(i < s.length){
    //     stack.push(s.charAt(i))
    //     i++
    // }

    // solution 3
    // i = 0
    // while(i < s.length){
    //     rst += stack.pop()
    //     i++
    // }

    // solution 4
    let i = s.length - 1
    let rst = []
    while(i >= 0){
        rst.push(s[i--])
    }

    return rst.join("")

    // solution 5
    // var arr = s.split("")
    // arr = arr.reverse()
    // return arr.join("")




};
