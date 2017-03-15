/**
 * @param {number[]} nums
 * @return {number[][]}
 */
 // take away
 // the ArrayOperation:
 // 1. arr/string deepcopy: arr.concat()
 // 2. array insert: arr.splice(insertIdx, removeCnt, val)

var permute = function(nums) {
    if(nums == null || nums.length == 0)
        return []

    var rst = []

    // init
    var tmp = [nums[0]]
    rst.push(JSON.parse(JSON.stringify(tmp)))
    var lvl = 1

    // iteration
    while(lvl < nums.length){
        let val = nums[lvl]
        var newRst = []
        rst.forEach(function(arr){
            for(let i = 0; i <= arr.length; i++){
                tmp = arr.concat()
                tmp.splice(i,0,val)
                newRst.push(tmp)
            }
        })

        rst = newRst
        lvl++
    }

    return rst

};
