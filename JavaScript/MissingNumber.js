/**
 * @param {number[]} nums
 * @return {number}
 */
var missingNumber = function(nums) {
    if(nums == null || nums.length == 0)
        return -1
    // solution 1
    // let i = 0
    // let missing = nums.length
    // while(i < nums.length){
    //     if(nums[i] != i){
    //         if(nums[i] == nums.length){
    //             missing = i
    //             i++
    //         }
    //         else{
    //             swap(nums[i], i, nums)
    //         }
    //     }
    //     else{
    //         i++
    //     }
    // }

    // solution 2
    let sum = 0
    let missing = 0
    for(let i = 0; i < nums.length; i++){
        sum += nums[i]
    }
    missing = (nums.length)*(1+nums.length)/2 - sum

    return missing
};

// helper for solution 2
var swap = function(a, b, nums){
    let temp = nums[a]
    nums[a] = nums[b]
    nums[b] = temp
}
