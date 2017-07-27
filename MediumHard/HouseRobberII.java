// take away:
// how to convert complex problem into simpler problem:
// define F(i,j) as the max profit taken from house i to j
// since nums[0] and nums[n-1] can not be robbed same time
// we have: F(0,n-1) = max(F(0,n-2), F(1,n-1))

public class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0)  return 0;
        if(nums.length == 1)  return nums[0];
        
        return Math.max(rob(nums,0,nums.length-2), rob(nums,1,nums.length-1));
        
    }
    
    public int rob(int[] nums, int from, int to){
        int inclusive = 0;
        int exclusive = 0;
        
        for(int k = from; k <= to; k++){
            int i = inclusive;
            int e = exclusive;
            
            inclusive = e + nums[k];
            exclusive = Math.max(i,e);
        }
        
        return Math.max(inclusive, exclusive);
    }
}