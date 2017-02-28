/**
 * @param {number[]} nums
 * @return {boolean}
 */
 // takeaway
 // for some reason, set is faster than map in javascript
 // so use set instead of map when possible
 // set also makes code more clean and readable
var containsDuplicate = function(nums) {
    if(nums == null || nums.length == 0)
        return false

    var set = new Set()
    for(let i = 0 ; i < nums.length; i++){
        if(!set.has(nums[i])){
            set.add(nums[i])
        }
        else{
            return true
        }
    }

    return false


};
