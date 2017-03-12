/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var rotate = function(nums, k) {
    if(nums == null || nums.length == 0){
        return
    }
    k = k % nums.length
    if(k <= 0)  return

    // solution 1: O(n)/O(n)
    // var arr = []
    // let leftShift = nums.length - k
    // for(let i = 0; i < nums.length; i++){
    //     arr[i] = nums[(i+leftShift)%nums.length]
    // }

    // for(let i = 0; i < nums.length; i++){
    //     nums[i] = arr[i]
    // }

    // solution 2: swaping by section O(n)/O(1)
    let left = 0
    let mid = nums.length - k
    let right = nums.length-1

    while(left < mid && mid < nums.length){
        let i = left
        let j = mid
        while(i < mid && j <= right){
            swap(nums,i++,j++)
        }

        left = i
        if(j <= right){
            mid = j
        }
    }


};

// solution 2 helper
var swap = function(nums, a, b){
  let temp = nums[b]
  nums[b] = nums[a]
  nums[a] = temp
};
