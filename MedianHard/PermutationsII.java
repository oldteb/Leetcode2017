// take away
// Note: dealing with duplication in BackTracking
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0){
            return rst;
        }

        // sort the nums
        Arrays.sort(nums);

        int[] buf = new int[nums.length];
        List<Integer> temp = new ArrayList<Integer>();
        dfs(temp, buf, 0, rst, nums);

        return rst;
    }

    void dfs(List<Integer> temp, int[] buf, int lvl, List<List<Integer>> rst, int[] nums){
        if(lvl == nums.length){
            List<Integer> newTmp = new ArrayList<Integer>(temp);
            rst.add(newTmp);
            return;
        }

        int last = -1;
        for(int i = 0; i < buf.length; i++){
            if(buf[i] == 1)  continue;
            if(last != -1 && nums[i] == nums[last])  continue;
            last = i;
            temp.add(nums[i]);
            buf[i] = 1;
            dfs(temp, buf, lvl+1, rst, nums);
            buf[i] = 0;
            temp.remove(temp.size()-1);
        }

        return;
    }




}
