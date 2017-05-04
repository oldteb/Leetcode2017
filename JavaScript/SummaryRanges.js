/**
 * @param {number[]} nums
 * @return {string[]}
 */
var summaryRanges = function(nums) {
    if(nums == null || nums.length == 0)
        return []

    var rst = []

    rst = dc(nums, 0 , nums.length-1)

    return rst
};

var dc = function(nums, start, end){
    if(start == end)
        return [nums[start].toString()]

    let mid = Math.floor((start + end)/2)
    var leftRange = dc(nums, start, mid)  // summary ranges from [start, mid]
    var rightRange = dc(nums, mid+1, end)  // summary ranges from [mid+1, end]

    // merge two summary ranges
    var rangeL = leftRange[leftRange.length-1]
    var rangeR = rightRange[0]
    var merged = mergeRange(rangeL, rangeR)
    if(merged == null)
        return leftRange.concat(rightRange)

    leftRange.splice(leftRange.length-1,1)
    rightRange.splice(0,1)
    return leftRange.concat(merged).concat(rightRange)
};

// merge two range
var mergeRange = function(rangeA, rangeB){
    var rangeA = getBound(rangeA)
    var rangeB = getBound(rangeB)

    if(rangeA[1] + 1 < rangeB[0])
        return null
    else
        return [rangeA[0].toString() + "->" + rangeB[1].toString()]
};

// get bound from a range
var getBound = function(range){
    let leftBound = 0
    let rightBound = 0

    if(range.includes("->")){
        var list = range.split("->")
        leftBound = parseInt(list[0])
        rightBound = parseInt(list[list.length-1])
    }
    else{
        leftBound = rightBound = parseInt(range)
    }

    return [leftBound, rightBound]
};
