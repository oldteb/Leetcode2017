// take away
// prove the runtime is O(n)

public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length == 0){
            return new ArrayList<Integer>();
        }
        
        int cur = 0;
        while(cur < nums.length){
            if(nums[cur] == cur+1){
                cur++;
                continue;
            }
            else if(nums[nums[cur]-1] == nums[cur]){
                cur++;
                continue;
            }
            else{
                swap(nums, cur, nums[cur]-1);
            }
        }
        
        List<Integer> rst = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i+1)
                rst.add(i+1);
        }
        
        return rst;
    }
    
    void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
