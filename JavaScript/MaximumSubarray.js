/**
 * @param {number[]} nums
 * @return {number}
 */
var maxSubArray = function(nums) {
    if(nums == null || nums.length == 0)
        return null

    let arr1 = new Array(nums.length);
    let arr2 = new Array(nums.length);

    arr1[0] = nums[0]
    arr2[0] = nums[0]

    for(let i = 1; i < nums.length; i++){
        arr1[i] = Math.max(arr1[i-1] ,arr2[i-1])
        arr2[i] = arr2[i-1] < 0 ? nums[i] : (arr2[i-1] + nums[i])
    }

    return Math.max(arr1[nums.length-1], arr2[nums.length-1])

    // Follow up: if the subarray is returned
    // var maxSum = 0
    // var from = 0
    // var to = nums.length-1
    // if(arr1[nums.length-1] > arr2[nums.length-1]){
    //     maxSum = arr1[nums.length-1]
    //     let i = nums.length-1
    //     for(; i >= 0; i--){
    //         if(arr1[i] == maxSum){
    //             continue
    //         }
    //         else{
    //             to = i
    //             break
    //         }
    //     }
    //     if(i == -1)
    //         to = 0
    // }
    // let j = to-1
    // for(; j >= 0; j--){
    //     if(arr2[j] < 0){
    //       break;
    //     }
    // }
    // from = j + 1
    // return nums.slice(from, to+1)

};
