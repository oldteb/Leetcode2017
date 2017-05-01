/**
 * @param {number[]} nums
 * @return {boolean}
 */
// take away
// no matter how hard the problem is
// with logical analysis process
// the problme can be solved
//
var increasingTriplet = function(nums) {
    if(nums == null || nums.length == 0){
        return false
    }

    // update implementation at 04/21/2017
    let midFound = 0
    let midVal = nums[0]  // maintain local minimum tuple
    let lowVal = nums[0]  // low val is stored for construct new minimum tuple

    for(let i = 1; i < nums.length; i++){
        if(midFound == 0){
            if(nums[i] <= lowVal)
                lowVal = nums[i]
            else{
                midVal = nums[i]
                midFound = 1
            }
        }
        else{
            if(nums[i] > midVal)  return true
            else if(nums[i] > lowVal){
                midVal = nums[i]
            }
            else
                lowVal = nums[i]
        }

    }


    return false
};
