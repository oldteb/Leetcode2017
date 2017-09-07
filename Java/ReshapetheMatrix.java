class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if(nums == null || nums.length == 0 || nums[0].length == 0)  return nums;
        if(nums.length * nums[0].length != r * c)  return nums;
        
        int[][] rst = new int[r][c];
        int i = 0, j = 0;
        int m = 0, n = 0;
        while(i < nums.length){
            rst[m][n] = nums[i][j];
            if(j == nums[0].length-1){
                i++;
                j = 0;
            }
            else{
                j++;
            }
            if(n == c-1){
                m++;
                n = 0;
            }
            else{
                n++;
            }
        }
        return rst;
    }
}