/**
 * @param {string} haystack
 * @param {string} needle
 * @return {number}
 */
var strStr = function(haystack, needle) {
    if(haystack == null || needle == null)
        return -1
    if(haystack.length == 0 && needle.length == 0)
        return 0

    for(let i = 0; i < haystack.length; i++){
        let tempStr = haystack.substring(i,i+needle.length)
        if(needle === tempStr)  return i
    }

    return -1
};
