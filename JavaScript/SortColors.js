/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
 // take away:
 // 1. for limited element type in an array, counting sort is a simple elegant way: two-pass O(n)/O(1)
 // 2. two/multi pointer solution is even faster though
var sortColors = function(nums) {
    if(nums == null | nums.length == 0)
        return

    // solution: two pointers
    let rIdx = 0
    let bIdx = nums.length - 1

    let cursor = 0
    while(cursor <= bIdx){
        if(nums[cursor] == 0){
            swap(nums, cursor, rIdx)
            rIdx++
            cursor++
        }
        else if(nums[cursor] == 1){
            cursor++
        }
        else if(nums[cursor] == 2){
            swap(nums, cursor, bIdx)
            bIdx--
        }
        else{
            return  // error
        }
    }

};

var swap = function(nums, a, b){
    let tmp = nums[a]
    nums[a] = nums[b]
    nums[b] = tmp
}
