/**
 * @param {string} s
 * @param {number} k
 * @return {number}
 */
// take away
// 1. when there is no thoughts, use brute force to solve the problem (as solution 1)
// 2. try to think out of box if no dp solution found
// 3.

var longestSubstring = function(s, k) {
    if(s == null || s.length == 0 || k < 0){
        return 0
    }

    if(s.length < k){
        return 0
    }

    // solution 2: diveide & conquer O(nlog(n))
    let maxLen = 0
    var map = new Map()
    for(let i = 0; i < s.length; i++){
        let c = s.charAt(i)
        let freq = map.has(c) ? map.get(c)+1 : 1
        map.set(c, freq)
    }
    for(let i = 0; i < s.length; i++){
        let c = s.charAt(i)
        if(map.get(c) < k){
            let lastIdx = 0
            var arrs = s.split(c)
            arrs.forEach(function(str){
              maxLen = Math.max(longestSubstring(str, k), maxLen)
            })
            return maxLen
        }
    }

    return s.length

    // solution 1: brute force O(n^2)/O(n)
    // var map1 = new Map()
    // var map2 = new Map()
    // let maxLen = 0
    // for(let i = 0; i < s.length; i++){
    //     map1.clear()
    //     map2.clear()
    //     for(let j = i; j < s.length; j++){
    //         let c = s.charAt(j)
    //         let freq = map1.has(c) ? map1.get(c)+1 : 1
    //         map1.set(c, freq)
    //         if(freq >= k){
    //             if(map2.has(c)){
    //                 map2.delete(c)
    //             }
    //             if(map2.size == 0){
    //                 maxLen = Math.max(maxLen, j-i+1)
    //             }
    //         }
    //         else{
    //             map2.set(c,1)
    //         }
    //     }
    // }

    return maxLen
};
