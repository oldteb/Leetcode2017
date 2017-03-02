/**
 * @param {number[]} nums
 * @return {number}
 */
 // DP formula:
 // nt(x) = max(nt(x-1), ct(x-1))
 // ct(x) = nt(x-1) + nums[x]
var rob = function(nums) {
    if(nums == null || nums.length == 0)
        return 0

    if(nums.length == 1)  return nums[0]

    let nt = 0  // largest sum if skip most recent house
    let ct = nums[0]  // largest sum if most recent house is counted

    for(let i = 1; i < nums.length; i++){
        let ntNew = Math.max(nt,ct)
        ct = nt + nums[i]
        nt = ntNew
    }

    return Math.max(nt, ct)

};
