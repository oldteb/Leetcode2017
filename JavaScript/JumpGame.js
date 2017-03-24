/**
 * @param {number[]} nums
 * @return {boolean}
 */
 // understand the question thoroughly
 // always seeking a better solution and a naive solution
var canJump = function(nums) {
    if(nums == null || nums.length == 0){
        return false
    }

    // solution 1: DFS naive
    // var buf = []
    // for(let i = 0; i < nums.length; i++){
    //     buf[i] = 0
    // }
    // return dfs(0, buf, nums)

    // solution 2 O(n)
    let range = 0
    let i = 0
    while(i < nums.length){
        if(i > range)  return false
        range = Math.max(range, i+nums[i])
        if(range >= nums.length-1)  return true
        i++
    }

    return false
};

// solution 1
var dfs = function(i, buf, nums){
    if(i >= nums.length)  return false
    if(i == nums.length - 1)  return true

    if(buf[i] == 1)  return false

    for(let j = 1; j <= nums[i]; j++){
        if(dfs(i+j, buf, nums))  return true
    }

    buf[i] = 1
    return false
};
