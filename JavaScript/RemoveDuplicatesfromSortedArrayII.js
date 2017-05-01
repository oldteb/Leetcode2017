/**
 * @param {number[]} nums
 * @return {number}
 */
 // take away:
 // remember to read the question carefully!!
var removeDuplicates = function(nums) {
    if(nums == null || nums.length == 0)
        return 0

    // sorted array
    let i = 0
    for(let j = 0; j < nums.length; j++){
        let n = nums[j]
        if (i < 2 || n > nums[i - 2])
            nums[i++] = n
    }

    return i;

    // var map = new Map()
    //
    // 2-pointers: backward swaping
    // let i = 0
    // let j = nums.length-1
    // while(i <= j){
    //     let val = nums[i]
    //     let freq = map.has(val) ? map.get(val) : 0
    //     if(freq < 2){
    //         map.set(val, freq+1)
    //         i++
    //     }
    //     else{
    //         swap(nums,i,j)
    //         j--
    //     }
    // }

    // 2-pointers: forward swaping
    // let i = 0
    // let j = 0
    // while(j < nums.length){
    //     let val = nums[j]
    //     let freq = map.has(val) ? map.get(val) : 0
    //     if(freq < 2){
    //         map.set(val, freq+1)
    //         swap(nums,i,j)
    //         i++
    //     }
    //     j++
    // }

    // return i
};

var swap = function(nums, i, j){
    let tmp = nums[i]
    nums[i] = nums[j]
    nums[j] = tmp
};
