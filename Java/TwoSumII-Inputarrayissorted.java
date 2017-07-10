public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers == null || numbers.length < 2)
            return new int[2];
        
        int left = 0;
        int right = numbers.length-1;
        
        while(left < right){
            int sum = numbers[left]+numbers[right];
            if(sum == target)
                break;
            else if(sum < target)
                left++;
            else
                right--;
        }
        
        int[] rst = new int[2];
        if(left != right){
            rst[0] = left+1;
            rst[1] = right+1;
        }
        
        return rst;
    }
}