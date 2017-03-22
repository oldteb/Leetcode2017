/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
 // take away
 // BS search template:
// while(left < right){
//     mid = (left+right)/2
//     if(val[mid]){...}
//     else{
//       mid = right-1 or left+1
//     }
// }
// if(left == right) ...
// else ...

var search = function(nums, target) {
    if(nums == null || nums.length == 0)
        return -1

    let left = 0
    let right = nums.length-1
    let line = nums[0]

    while(left < right){
        let mid = Math.floor((left + right)/2)
        if(nums[mid] == target)  return mid
        if(nums[mid] >= line){
            if(nums[mid] > target && target >= line){
                right = mid-1
            }
            else{
                left = mid+1
            }
        }
        else{
            if(nums[mid] < target && target < line){
                left = mid+1
            }
            else{
                right = mid-1
            }
        }
    }

    if(left == right && nums[left] == target)  return left

    return -1

};
