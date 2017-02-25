/**
 * @param {number[]} nums
 * @return {number}
 */
var majorityElement = function(nums) {
    if(nums == null || nums.length == 0)
        return null

    // solution 1
    // var sortedArr = nums.sort()
    // return sortedArr[Math.floor(sortedArr.length/2)]

    // solution 2
    let major = 0
    let maxCnt = 0
    var map = new Map()

    nums.forEach(function(element) {
        let cnt = map.has(element) ? map.get(element) : 0
        cnt++
        if(cnt > maxCnt){
            major = element
            maxCnt = cnt
        }
        map.set(element, cnt)
    });

    return major

};
