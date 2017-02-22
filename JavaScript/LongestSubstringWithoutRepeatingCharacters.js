/**
 * @param {string} s
 * @return {number}
 */
 // takeaway if the result is a number not a specific string
 // it is most likely has a greedy solution
var lengthOfLongestSubstring = function(s) {
    if(s == null || s.length == 0)
        return 0

    var map = {}
    let fn = 1
    let mn = 1
    map[s[0]] = 0
    for(let i = 1; i < s.length; i++){
        if(map[s[i]] == null){
            mn++
        }
        else{
            let diff = i-map[s[i]]
            if(diff <= mn)
                mn = diff
            else
                mn++
        }

        map[s[i]] = i

        if(fn < mn)
            fn = mn

        // early loop ending. for speeding up
        if(mn + s.length - i - 1 <= fn)
            break
    }

    return fn

};
