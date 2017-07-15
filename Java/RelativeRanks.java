public class Solution {
    public String[] findRelativeRanks(int[] nums) {
        if(nums == null || nums.length == 0)
            return new String[0];
        
        String[] buf = {"Gold Medal", "Silver Medal", "Bronze Medal"};
        
        Map<Integer, Integer> refMap = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < nums.length; i++)
            refMap.put(nums[i], i);
        
        Arrays.sort(nums);
        
        String[] rst = new String[nums.length];
        
        for(int cnt = 1, i = nums.length-1; i >= 0; i--,cnt++)
            rst[refMap.get(nums[i])] = cnt <= 3 ? buf[cnt-1] : String.valueOf(cnt);

        return rst;
    }
}