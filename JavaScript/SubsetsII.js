/**
 * @param {number[]} nums
 * @return {number[][]}
 */
 // take away
 // typical backtracking problem
 // sort the array to deal with repeating characters
var subsetsWithDup = function(nums) {
    var rst = []
    if(nums == null || nums.length == 0)
        return rst

    var buf = []
    nums.sort()
    backTracking(nums, 0, buf, rst)

    return rst
};

// generate all subsets which each of them = buf + subset(i,nums.length)
var backTracking = function(nums, i, buf, rst){
    if(i == nums.length){
        var tmp = buf.concat()
        rst.push(tmp)
        return
    }

    // get max subsets length for repeating character
    let m = i+1
    while(m < nums.length){
        if(nums[m] == nums[i])  m++
        else break
    }
    let len = m-i  // len of repeating character from index i

    backTracking(nums,m,buf,rst)  // skip current character
    for(let n = 0; n < len; n++){   // use current character(s)
        buf.push(nums[i])
        backTracking(nums,m,buf,rst)
    }

    buf.splice(buf.length-len, len)  // remove added data in current level before return

    return
};
