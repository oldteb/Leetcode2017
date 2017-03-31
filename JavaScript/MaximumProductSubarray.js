/**
 * @param {number[]} nums
 * @return {number}
 */
 // take away:
 // keyword: Maximum => DP
 // keyword: Subarray => Greedy
 // Recursion equation:
 // Let F(x) is the max product of subarray [0~x]
 // LN(x) is max product of subarray from anywhere to x [.~x]
 // LP(x) is min product of subarray from anywhere to x [.~x]
 // Then F(x) = MAX: 1) F(x-1)
 //                  2) MAX(LN(x-1)*num[x], num[x]),  num[x] <= 0
 //                  3) MAX(LP(x-1)*num[x], num[x]),  num[x] > 0
 // note: remember to maintain the LN since smallest negative number multiply another negative becomes large positive
var maxProduct = function(nums) {
    if(nums == null || nums.length == 0)
        return -1

    let fn = nums[0]
    let lp = nums[0]
    let ln = nums[0]

    for(let i = 1; i < nums.length; i++){
        let tmp1 = Math.max(lp * nums[i], ln * nums[i])
        let newlp = Math.max(tmp1, nums[i])
        let tmp2 = Math.min(lp * nums[i], ln * nums[i])
        let newln = Math.min(tmp2, nums[i])

        lp = newlp
        ln = newln

        fn = Math.max(lp, fn)
    }

    return fn
};
