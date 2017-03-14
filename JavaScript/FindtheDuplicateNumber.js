/**
 * @param {number[]} nums
 * @return {number}
 */
var findDuplicate = function(nums) {
    if(nums == null || nums.length == 0)
        return 0

    var bitArr = []
    for(let i = 0; i < 32; i++){
        bitArr[i] = 0
        for(let j = 1; j < nums.length; j++){
            bitArr[i] += ((j>>(31-i)) & 0x01)
        }
    }

    var newArr = []
    for(let i = 0; i < 32; i++){
        newArr[i] = 0
        for(let j = 0; j < nums.length; j++){
            newArr[i] += ((nums[j]>>(31-i)) & 0x01)
        }
    }

    let rst = 0
    let lvl = 1
    for(let i = 31; i >= 0; i--){
        if(newArr[i] > bitArr[i]){
            rst += lvl
        }
        lvl *= 2
    }

    return rst

};
