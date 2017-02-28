/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 */
var intersect = function(nums1, nums2) {
    if(nums1 == null || nums2 == null)
        return null

    // var map1 = new Map()
    // var map2 = new Map()

    // nums1.forEach(function(element){
    //     let cnt = map1.has(element) ? map1.get(element) : 0
    //     map1.set(element, cnt + 1)
    // })

    // nums2.forEach(function(element){
    //     let cnt = map2.has(element) ? map2.get(element) : 0
    //     map2.set(element, cnt + 1)
    // })

    // var list = []

    // map1.forEach(function(value, key, map){
    //     let cnt = map2.has(key) ? map2.get(key) : 0
    //     cnt = Math.min(value, cnt)
    //     for(let i = 0; i < cnt; i++){
    //         list.push(key)
    //     }
    // })

    var list = []

    var map1 = new Map()

    nums1.forEach(function(element){
        let cnt = map1.has(element) ? map1.get(element) : 0
        map1.set(element, cnt + 1)
    })

    nums2.forEach(function(element){
        if(map1.has(element) && map1.get(element) != 0){
            map1.set(element, map1.get(element) - 1)
            list.push(element)
        }
    })

    return list

};
