public class Solution {
    public int[] constructRectangle(int area) {
        int[] rst = new int[2];
        if(area <= 0)  return rst;
        
        int width = (int)Math.sqrt(area);
        
        while( width > 1 && area % width != 0){
            width--;
        }
        
        rst[0] = area / width;
        rst[1] = width;
        
        return rst;
    }
}