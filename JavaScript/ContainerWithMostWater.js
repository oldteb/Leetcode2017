/**
 * @param {number[]} height
 * @return {number}
 */
var maxArea = function(height) {
    if(height == null || height.length < 2)
        return 0

    let leftIdx = 0
    let rightIdx = height.length-1
    let largest = Number.MIN_SAFE_INTEGER

    while(leftIdx < rightIdx){
        let area = (rightIdx - leftIdx) * Math.min(height[leftIdx], height[rightIdx])
        largest = Math.max(largest, area)
        if(height[leftIdx] < height[rightIdx]){
            leftIdx++
        }
        else{
            rightIdx--
        }
    }

    return largest
};
