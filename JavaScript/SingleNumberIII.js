/**
 * @param {number[]} nums
 * @return {number[]}
 */
 // take away:
 // learned a lesson:
 // try to connect to similar problem, then try to convert/decompose to similar problem
 // This problme is decomposed to sub problem: SingleNumber.js
var singleNumber = function(nums) {
    if(nums == null || nums.length == 0)
        return []

    let xorSum = 0
    nums.forEach(function(e){
        xorSum ^= e
    });

    // check bit
    let mask = 1
    for(let i = 0; i < 32; i++){
        if(xorSum & mask){
            break
        }
        mask <<= 1
    }
    if(mask == 0)  return []  // do not existed

    // group elements
    let xor1 = 0
    let xor2 = 0
    nums.forEach(function(e){
        if(e & mask){
            xor1^=e
        }
        else{
            xor2^=e
        }
    });

    return [xor1, xor2]


};
