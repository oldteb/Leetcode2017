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

      // // solution 1: naive DP (O(n^2))
      // // buf[k] records the len of longest subsequence found in [0..k-1],
      // // which ends with nums[k]
      // var buf = Array(nums.length).fill(1)
      // let rst = 1
      // for(let i = 1; i < nums.length; i++){
      //     let maxLen = 0
      //     for(let j = 0; j < i; j++){
      //         if(nums[j] < nums[i] && buf[j] > maxLen)
      //             maxLen = buf[j]
      //     }
      //     buf[i] = maxLen + 1
      //     rst = Math.max(rst, buf[i])  // maintaint the largest among buf[]
      // }

      // solution 2: DP + BS (O(nlgn))
      //  So dp[i] is the minimum value a subsequence of length i+1 might end with.
      var buf = Array(nums.length).fill(0)
      let len = 0
      for(let i = 0; i < nums.length; i++){
          let insertPoint = myBinarySearch(buf, len, nums[i])
          buf[insertPoint] = nums[i]
          if(len == insertPoint)
              len++
      }

      return len
  };

  var myBinarySearch = function(buf, len, target){
      if(len <= 0 || buf[len-1] < target)
          return len

      let left = 0
      let right = len-1
      while(left < right){
          let mid = Math.floor((left+right)/2)
          if(target <= buf[mid])
              right = mid
          else
              left = mid + 1
      }

      return left
  };
