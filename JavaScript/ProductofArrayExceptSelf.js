/**
 * @param {number[]} nums
 * @return {number[]}
 */
 // it can be implemented with O(1) space
var productExceptSelf = function(nums) {
    if(nums == null || nums.length == 0)
        return nums

    var list = new Array(nums.length)
    list[0] = 1
    for(let i = 1; i < nums.length; i++){
        list[i] = list[i-1] * nums[i-1]
    }

    var buffer = nums[nums.length-1]
    for(let i = nums.length - 2; i >= 0; i--){
        list[i] = buffer * list[i]
        buffer = buffer * nums[i]
    }

    return list

};
