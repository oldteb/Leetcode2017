/**
 * @param {number[]} nums
 * @return {boolean}
 */
// take away
// no matter how hard the problem is
// with logical analysis process
// the problme can be solved
var increasingTriplet = function(nums) {
    if(nums == null || nums.length == 0){
        return false
    }

    let sm = nums[0]
    let md = 0
    let smIdx = 0
    let mdIdx = -1

    // find the first increasing tuple in array
    for(let i = 1; i < nums.length; i++){
        if(nums[i] > sm){
            md = nums[i]
            mdIdx = i
            break
        }
        sm = nums[i]
        smIdx = i
    }

    if(mdIdx == -1)
        return false

    // for each step
    // always maintain the local optimal: the "minimum" increasing tuple
    // maintain the local minimum value to update the local optimal
    let minVal = sm
    for(let i = mdIdx+1; i < nums.length; i++){
        if(nums[i] > md)  return true
        else if(nums[i] < md && nums[i] > sm){
            md = nums[i]
        }
        else if(nums[i] > minVal){
            sm = minVal
            md = nums[i]
        }
        else if(nums[i] < minVal){
            minVal = nums[i]
        }
    }


    return false
};
