// take away:
/* 
let's define sum as the sum of all the numbers, before any moves; minNum as the min number int the list; n is the length of the list;

After, say m moves, we get all the numbers as x , and we will get the following equation

 sum + m * (n - 1) = x * n
and actually,

  x = minNum + m
and finally, we will get

  sum - minNum * n = m
So, it is clear and easy now.

*/

public class Solution {
    public int minMoves(int[] nums) {
        // solution 1: O(n)
        int steps = 0;
        int min = nums[0];
        for(int n : nums)
            min = Math.min(min,n);
        for(int n : nums)
            steps += n-min;
        
        return steps;
 
//         // solution 2: O(n)
//         int minIdx = 0;
//         int maxIdx = 0;
//         int steps = 0;
        
//         for(int i = 0; i < nums.length; i++){
//             if(nums[maxIdx] < nums[i])  maxIdx = i;
//             if(nums[minIdx] > nums[i])  minIdx = i;
//         }
        
//         while(nums[minIdx] < nums[maxIdx]){
//             int skipIdx = maxIdx;
//             minIdx = 0;
//             maxIdx = 0;
//             for(int i = 0; i < nums.length; i++){
//                 if(i != skipIdx)
//                     nums[i]++;
//                 if(nums[maxIdx] < nums[i])  maxIdx = i;
//                 if(nums[minIdx] > nums[i])  minIdx = i;
//             }
//             steps++;
//         }
//        
//         return steps;
    }
    
}