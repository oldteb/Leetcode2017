public class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0)
            return 0;

        Stack<Integer> stairs = new Stack<Integer>();
        int maxArea = 0;

        int[] bufH = new int[heights.length+1];
        for(int i = 0; i < heights.length; i++){
            bufH[i] = heights[i];
        }

        for(int i = 0; i < bufH.length; i++){
            if(stairs.size() == 0 || bufH[i] >= bufH[stairs.peek()]){
                stairs.push(i);
            }
            else{
                while(stairs.size() != 0 && bufH[i] < bufH[stairs.peek()]){
                    int idx = stairs.pop();
                    int width =  stairs.size() == 0 ? i : i - stairs.peek() - 1;
                    maxArea = Math.max(maxArea, bufH[idx] * width);
                }
                stairs.push(i);
            }
        }

        return maxArea;
    }
}
