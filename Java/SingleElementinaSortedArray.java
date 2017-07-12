public class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        
        int left = 0;
        int right = nums.length-1;
        
        while(left < right){
            int mid = (right-left)/2+left;
            if(nums[mid-1] != nums[mid] && 
                nums[mid+1] != nums[mid])
                return nums[mid];
            
            if(mid%2 == 0){
                if(nums[mid+1] == nums[mid])
                    left = mid+2;
                else
                    right = mid-2;
            }
            else{
                if(nums[mid+1] != nums[mid])
                    left = mid+1;
                else
                    right = mid-1;
            }
        }
        
        return nums[left];
    }
}