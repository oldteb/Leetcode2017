/**
 * @param {number[]} nums
 * @return {number}
 */
 // take away:
 // typical bit-wise solution to duplication problem
var singleNumber = function(nums) {
    if(nums == null || nums.length == 0)
        return 0

    let rst = 0
    let mask = 1
    let tmp = 0
    for(let i = 0; i < 32; i++){
        let cnt = 0
        for(let j = 0; j < nums.length; j++){
            tmp = nums[j] & mask
            cnt += (tmp>>i)
        }

        tmp = cnt % 3
        rst |= (tmp<<i)
        mask <<= 1
    }

    return rst
};
