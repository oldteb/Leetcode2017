// take away
// observe that the elements is 1-1 mapped to index
// we can use "find own place" to replace the element
// we can also use given array space avoid taking extra space

public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> rst = new ArrayList<Integer>();
        
        if(nums == null || nums.length == 0)
            return rst;
        
        for(int i = 0; i < nums.length; i++){
            int val = nums[i] & (~0x80000000);
            if(nums[val-1] < 0)
                rst.add(val);
            else
                nums[val-1] = nums[val-1] | 0x80000000;
        }
        
        return rst;
    }
}