// take away:
// solution 1: use Two sum: O(n^2)
// solution 2: DFS

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0)
            return rst;

        Arrays.sort(nums);

        for(int i = 0; i < nums.length-2; i++){
            int left = i+1;
            int right = nums.length-1;

            if(i != 0 && nums[i] == nums[i-1]){
                continue;
            }


            while(left < right){
                if(left != i+1 && nums[left-1] == nums[left]){
                    left++;
                    continue;
                }
                if(right != nums.length-1 && nums[right+1] == nums[right]){
                    right--;
                    continue;
                }
                int sum2 = nums[left] + nums[right];
                if(sum2 < 0-nums[i]){
                    left++;
                }
                else if(sum2 > 0-nums[i]){
                    right--;
                }
                else{
                    List<Integer> triplet = new ArrayList<Integer>();
                    triplet.add(nums[i]);
                    triplet.add(nums[left]);
                    triplet.add(nums[right]);
                    rst.add(triplet);
                    left++;
                    right--;
                }

            }
        }

        return rst;
    }
}
