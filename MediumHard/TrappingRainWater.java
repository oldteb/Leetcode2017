public class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0)
            return 0;

        int totalWater = 0;
        int[] buf1 = new int[height.length];
        int[] buf2 = new int[height.length];
        
        // calculate the heighest wall to the left
        buf1[0] = 0;
        for(int i = 1; i < height.length; i++){
            buf1[i] = Math.max(height[i-1], buf1[i-1]);
        }

        // calculate the heighest wall to the right
        buf2[height.length-1] = 0;
        for(int i = height.length-2 ; i >= 0; i--){
            buf2[i] = Math.max(height[i+1], buf2[i+1]);
        }

        // the max water each column can hold is min(heighest wall to the left, heighest wall to the right)
        for(int i = 0; i < height.length; i++){
            int tmp = Math.min(buf1[i],buf2[i]);
            if(tmp > height[i]){
                totalWater += (tmp - height[i]);
            }
        }

        return totalWater;

    }
}
