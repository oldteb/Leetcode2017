/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var searchRange = function(nums, target) {
    if(nums == null || nums.length == 0)
        return [-1,-1]

    // find a element whose value is target
    let left = 0
    let right = nums.length-1
    let mid = -1
    while(left <= right){
        mid = Math.floor((left+right)/2)
        if(nums[mid] == target){
            break
        }
        else if(nums[mid] < target)  left = mid+1
        else  right = mid-1
    }

    if(left > right) return [-1,-1]

    left = findLeftBound(nums, left, mid, target)
    right = findRightBound(nums, mid, right, target)

    return [left, right]
};

var findLeftBound = function(nums, left, right, target){
    while(left < right){
        let mid = Math.floor((left+right)/2)
        if(nums[mid] == target){
            right = mid
        }
        else
            left = mid+1
    }

    return left
};

var findRightBound = function(nums, left, right, target){
    while(left < right){
        let mid = Math.floor((left+right)/2)
        if(nums[mid] == target){
            left = mid+1
        }
        else
            right = mid-1
    }

    if(nums[left] != target)  return left-1
    else return right
};
