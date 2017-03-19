/**
 * @param {number[]} nums
 * @return {number}
 */
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
        console.log(buf)
    }



    return buf[0]
};

var list = [10,9,2,5,3,7,101,18]
lengthOfLIS(list)
