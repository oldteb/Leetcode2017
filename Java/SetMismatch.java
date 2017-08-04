/*
-- Take Away --

There are 4 ways to solve this problem: (from slow to fast)
    1. sort the array O(n^2)/O(1)
    2. Set O(n)/O(n)
    3. Bit Manipulation: O(n)/O(1)   (if the value range is limited)
    4. Binary Search: lg(n)      (if the array is ordered)
*/

public class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] rst = new int[2];
        if(nums == null || nums.length == 0)
            return rst;
        
        int mask = 0x10000;
        
        for(int i = 0; i < nums.length; i++){
            int num = nums[i] & (~mask);
            if((nums[num-1] & mask) != 0){
                rst[0] = num;
            }
            else{
                nums[num-1] |= mask;
            }
        }
        
        for(int i = 0; i < nums.length; i++){
            if((nums[i] & mask) == 0){
                rst[1] = i+1;
                break;
            }
        }
        
        return rst;
             
    }
}