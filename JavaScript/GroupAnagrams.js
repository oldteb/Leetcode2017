/**
 * @param {string[]} strs
 * @return {string[][]}
 */
 // take away:
 // 1. the porperty of anagrams:
 //   1) same result after sort
 //   2) same map of statistic
 // 2. use forEach method to loop a map
 // 3. javascript does not support ASCII calculation
var groupAnagrams = function(strs) {
    if(strs == null || strs.length == 0){
        return []
    }

    var map = new Map
    strs.forEach(function(str){
        let sig = getSignature(str)
        if(map.has(sig)){
            let list = map.get(sig)
            list.push(str)
        }
        else{
            var list = []
            list.push(str)
            map.set(sig, list)
        }
    })

    var rst = []
    map.forEach(function(value, key){
        rst.push(value)
    })

    return rst
};

var getSignature = function(str){
    var buf = []
    var signature = ""

    for(let i = 0; i < 26; i++){
        buf[i] = 0
    }

    for(let i = 0 ; i < str.length; i++){
        let c = str.charAt(i)
        buf[c.charCodeAt(0) - 97]++
    }

    for(let i = 0; i < buf.length; i++){
        if(buf[i] > 0){
            signature += String.fromCharCode(97 + i)
            signature += buf[i].toString()
        }
    }

    return signature
};
