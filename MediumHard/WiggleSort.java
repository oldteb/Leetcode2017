public class Solution {
    public void wiggleSort(int[] nums) {
        if(nums == null || nums.length <= 1)
            return;
        
        // find median & partition
        int median = findMedian(nums);
        
        System.out.println(median);
        for(int n : nums)
            System.out.println(n);
        
        // swap
        int left = 1;
        int right = median%2==0 ? median : median+1;
        while(left <= median && right < nums.length){
            swap(nums, left, right);
            left += 2;
            right += 2;
        } 
        
        if(right == nums.length-1){
            int num1 = nums[right-1];
            int num2 = nums[right];
            nums[right] = Math.min(num1, num2);
            nums[right-1] = Math.max(num1, num2);
        }
    }
    
    int findMedian(int[] nums){
        int left = 0;
        int right = nums.length - 1;
        int k = nums.length/2;
        
        while(left < right){
            int mid = partition(nums, left, right);
            if(mid == k)
                return mid;
            else if(mid > k)
                right = mid-1;
            else
                left = mid+1;
        }
        
        return left;
    }
    
    int partition(int[] nums, int left, int right){
        int cur = left+1;
        int mid = cur;
        while(cur <= right){
            if(nums[cur] <= nums[left]){
                swap(nums, mid, cur);
                mid++;
            }
            cur++;
        }
        
        swap(nums, left, mid-1);
        
        return mid-1;
    }
    
    void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
}