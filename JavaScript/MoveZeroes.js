/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var moveZeroes = function(nums) {

    if(nums == null || nums.length == 0)
        return nums

    let cnt = 0
    for(let i = 0; i < nums.length; i++){
        if(nums[i] != 0)
            nums[cnt++] = nums[i]
    }

    for(let i = nums.length-1; i >= cnt; i--){
        nums[i] = 0
    }

};
