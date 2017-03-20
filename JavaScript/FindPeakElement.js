/**
 * @param {number[]} nums
 * @return {number}
 */
 // take away
 // If there is a obvious solution
 // then it is very likely that a faster solution exists.
 // When O(lg(n)) time is required, Binary Search should be the first to consider.

var findPeakElement = function(nums) {
    if(nums == null || nums.length == 0)
        return 0
    let i = 0
    let j = nums.length - 1

    while(i <= j){
        let mid = Math.floor((i+j)/2)
        let left = mid-1 >= 0 ? nums[mid-1] : Number.MIN_SAFE_INTEGER
        let right = mid+1 < nums.length ? nums[mid+1] : Number.MIN_SAFE_INTEGER

        if(nums[mid] > left && nums[mid] > right)
            return mid
        else if(nums[mid] < left && nums[mid] > right){
            j = mid-1
        }
        else{
            i = mid+1
        }
    }

    return 0
};
