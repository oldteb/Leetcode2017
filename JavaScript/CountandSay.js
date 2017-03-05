/**
 * @param {number} n
 * @return {string}
 */
var countAndSay = function(n) {
    let str = "1"
    
    if(n == 1)  return str
    
    for(let i = 1; i < n; i++){
        let newStr = ""
        for(let j = 0; j < str.length;){
            let last = str.charAt(j)
            let cnt = 1
            let k = j + 1
            while(k < str.length && last==str.charAt(k)){
                k++
                cnt++
            }
            j = k
            newStr += cnt
            newStr += last
        }
        str = newStr
    }
    
    return str
    
};
