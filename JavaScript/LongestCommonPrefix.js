/**
 * @param {string[]} strs
 * @return {string}
 */
 // take away
 // string.charAt(index) can be replaced by string[idx]
var longestCommonPrefix = function(strs) {
    if(strs == null || strs.length == 0)
        return ''

    let prefixLen = 0

    while(true){
        if(prefixLen >= strs[0].length)  break
        let char = strs[0][prefixLen]

        let mismatch = false
        for(let i = 1; i < strs.length; i++){
            if(prefixLen >= strs[i].length || char != strs[i][prefixLen]){
                mismatch = true
                break
            }
        }

        if(mismatch)  break
        else prefixLen++
    }

    return strs[0].substring(0, prefixLen)

};
