/**
 * @param {number[]} nums
 * @return {number}
 */
 // takeaway
 // Map class is similar to Map in Java
 // but with different function names
 
var singleNumber = function(nums) {
    if(nums == null)
        return

    // solution 1
    // let xorsum = 0
    // for(let i = 0; i < nums.length; i++){
    //     xorsum ^= nums[i]
    // }
    // return xorsum

    // solution 2
    var map = new Map();

    for(let i = 0; i < nums.length; i++){
        if(map.has(nums[i]) == true)
            map.delete(nums[i])
        else
            map.set(nums[i], 1)
    }

    var iter = map.keys()
    return iter.next().value

};
