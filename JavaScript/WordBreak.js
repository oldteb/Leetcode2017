/**
 * @param {string} s
 * @param {string[]} wordDict
 * @return {boolean}
 */
var wordBreak = function(s, wordDict) {
    if(s == null || s.length == 0 || wordDict == null || s.length == 0)
        return false

    var map = new Map
    var buf = []
    for(let i = 0; i < s.length; i++){
        buf[i] = 0
    }

    for(let i = 0; i < wordDict.length; i++){
        map.set(wordDict[i],0)
    }

    return dfs(s, 0, buf, map)
};

var dfs = function(s, i, buf, map){
    if(i == s.length)  return true

    if(buf[i] == 1)  return false

    for(let j = i; j < s.length; j++){
        let str = s.substring(i,j+1)
        if(map.has(str)){
            if(dfs(s, j+1, buf, map))  return true
        }
    }

    buf[i] = 1
    return false

};
