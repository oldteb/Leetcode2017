/**
 * @param {string} s
 * @param {number} k
 * @return {number}
 */
var longestSubstring = function(s, k) {
    if(s == null || s.length == 0 || k < 0){
        return 0
    }

    if(s.length < k){
        return 0
    }

    console.log(s)

    let maxLen = 0
    var map = new Map()

    // solution 2: diveide & conquer
    for(let i = 0; i < s.length; i++){
        let c = s.charAt(i)
        let freq = map.has(c) ? map.get(c)+1 : 1
        map.set(c, freq)
    }
        console.log(map)

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

    // solution 1: brute force O(n2)/O(n)
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


console.log(longestSubstring("bbaaacbd",3))
