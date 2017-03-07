/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
// take away
// a) solution 1: use Map O(n)/O(n)
// b) solution 2: two pointer based on sorted array(O(nlg(n))/O(1))
 var twoSum = function(nums, target) {
     if(nums == null || nums.length == 0)
         return []

     let leftIdx = 0
     let rightIdx = nums.length - 1
     let leftValue
     let rightValue

     //
     var sortedList = []
     nums.forEach(function(element){
       sortedList.push(element)
     })

     sortedList.sort(function(a,b){
       if(a < b)  return -1
       else if(a > b)  return 1
       else return 0
     })

     while(leftIdx < rightIdx){
         let sum = sortedList[leftIdx] + sortedList[rightIdx]
         if(sum == target){
             leftValue = sortedList[leftIdx]
             rightValue = sortedList[rightIdx]
             break
         }
         else if(sum < target){
             leftIdx++
         }
         else{
             rightIdx--
         }
     }

     leftIdx = -1
     rightIdx = -1
     for(let i = 0; i < nums.length; i++){
         if(leftIdx == -1 && nums[i] == leftValue)  leftIdx = i
         else if(rightIdx == -1 && nums[i] == rightValue) rightIdx = i
     }

     return [leftIdx, rightIdx]  // no solution found

 };
