/**
 * @param {number[]} nums
 * @return {number}
 */
var majorityElement = function(nums) {
    if(nums == null || nums.length == 0)
        return null

    // solution 1: Sort
    // var sortedArr = nums.sort()
    // return sortedArr[Math.floor(sortedArr.length/2)]

    // solution 2: Map
    // let major = 0
    // let maxCnt = 0
    // var map = new Map()
    // nums.forEach(function(element) {
    //     let cnt = map.has(element) ? map.get(element) : 0
    //     cnt++
    //     if(cnt > maxCnt){
    //         major = element
    //         maxCnt = cnt
    //     }
    //     map.set(element, cnt)
    // });
    // return major

    // solution 3: Moores voting algorithm
    let count = 1
    let majIdx = 0
    for(let i = 1; i < nums.length; i++){
        if(nums[majIdx] == nums[i])
            count++
        else
            count--
        if(count == 0){
           count = 1
           majIdx = i
        }
    }
    return nums[majIdx]

    // bit maipulation

};
