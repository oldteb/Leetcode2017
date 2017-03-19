/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsets = function(nums) {
    if(nums == null || nums.length == 0){
        return []
    }

    // init
    var rst = []
    var list = []
    rst.push(list)
    list = []
    list.push(nums[0])
    rst.push(list)

    for(let i = 1; i < nums.length; i++){
        var tmpLists = []
        for(let j = 0; j < rst.length; j++){
            var oldList = rst[j]
            var newList = oldList.concat()
            newList.push(nums[i])
            tmpLists.push(newList)
        }
        rst = rst.concat(tmpLists)
    }

    return rst

};
