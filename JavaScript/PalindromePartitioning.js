/**
 * @param {string} s
 * @return {string[][]}
 */
 // take away
 // The question requrn all possible values
 // so we use DFS to trversal all possible solution
 // refer to note "DFS Template" for greater detail about implementation
 // Performace analysis:
 //   1) unknown
 // Better solution:
 //   a) use a matrix to store if every substring sia palindrome
 //   b) if arr.substring(i,j) is a palindrome AND arr[i-1] == arr[j+1], then arr.substring(i-1,j+1) is also a palindrome
var partition = function(s) {
    if(s == null || s.length == 0)
        return []

    var rst = []
    var buf = []
    var rst = dfs(s, 0, buf, rst)
    return rst
};

var dfs = function(s, start, buf, rst){
    if(start > s.length)
        return 0

    if(start == s.length){
        var tmp = buf.concat()
        rst.push(tmp)
        return 1
    }

    for(let i = start; i < s.length; i++){
        if(isPalindrome(s, start, i)){
            buf.push(s.substring(start, i+1))
            dfs(s, i+1, buf, rst)
            buf.splice(buf.length-1,1)
        }
    }

    return rst
};

var isPalindrome = function(str, i, j){
    while(i < j){
        if(str.charAt(i) != str.charAt(j))  return false
        i++
        j--
    }
    return true
};
