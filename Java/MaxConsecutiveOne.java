public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if(nums == null || nums.length == 0)  return 0;
        int maxCnt = 0;
        int curCnt = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0)  curCnt = 0;
            else  maxCnt = Math.max(maxCnt, ++curCnt);
        }
        
        return maxCnt;
    }
}