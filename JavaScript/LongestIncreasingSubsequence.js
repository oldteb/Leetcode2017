/**
 * @param {number[]} nums
 * @return {number}
 */
 // take away
 // It is obviously has a DP solution:
 //   a) overlapping subproblems
 //   b) optimal substructure
 // Recursive equation:
 // Let L(i) be the len of max increasing subsequence from [0~i]
 // L(i) = a) 1 + max(L(x)), where 0<= x < i
  //       b) 1            , if no such x exists.

var lengthOfLIS = function(nums) {
    if(nums == null || nums.length == 0)
        return 0

    var nextArr = []
    for(let i = 0;i < nums.length; i++){
        var tmp = []
        for(let j = i+1; j < nums.length; j++){
            if(nums[j] > nums[i])
                tmp.push(j)
        }
        nextArr[i] = tmp
    }

    var buf = []
    for(let i=0; i < nums.length; i++){
        buf[i] = 0
    }

    for(let i = nums.length - 2; i >= 0; i--){
        var tmp = nextArr[i]
        if(tmp.length == 0)
          continue

        let max = Number.MIN_SAFE_INTEGER
        tmp.forEach(function(e){
            if(buf[e] > max)
                max = buf[e]
        })

        buf[i] = max + 1
    }

    let max = 0
    for(let i = 0; i < buf.length; i++){
        max = Math.max(buf[i], max)
    }

    return max + 1
};
