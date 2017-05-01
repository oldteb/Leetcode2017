/**
 * @param {number[]} nums
 * @return {number}
 */
 // similar to 33. Search in Rotated Sorted Array
var findMin = function(nums) {
    if(nums == null || nums.length == 0)
        return 0

    let leftIdx = 0
    let rightIdx = nums.length-1

    while(leftIdx < rightIdx){
        // check if area is sorted
        if(nums[rightIdx] >= nums[leftIdx])
            return nums[leftIdx]

        let midIdx = Math.floor((leftIdx + rightIdx)/2)

        if(nums[midIdx] < nums[leftIdx])
            rightIdx = midIdx
        else
            leftIdx = midIdx+1
    }

    return nums[leftIdx]
};
