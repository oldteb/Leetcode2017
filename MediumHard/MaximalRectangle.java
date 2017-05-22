public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int maxArea = 0;
        int height = matrix.length;
        int width = matrix[0].length;
        int[] h = new int[width];
        int[] leftBound = new int[width];
        int[] rightBound = new int[width];

        Arrays.fill(leftBound,  0);
        Arrays.fill(rightBound, width-1);

        for(int i = 0; i < height; i++){
            int currLeft = 0;
            int currRight = width-1;
            for(int j = width-1; j >= 0; j--){
                if(matrix[i][j] == '0'){
                    currRight = j-1;
                    rightBound[j] = width;
                }
                else{
                    rightBound[j] = Math.min(rightBound[j], currRight);
                }
            }

            for(int j = 0; j < width; j++){
                if(matrix[i][j] == '0'){
                    h[j] = 0;
                    currLeft = j+1;
                    leftBound[j] = -1;
                }
                else{
                    h[j] = i==0 ? 1 : h[j]+1;
                    leftBound[j] = Math.max(leftBound[j], currLeft);
                }

                // calculate max rectangle area
                maxArea = Math.max(maxArea, h[j]*(rightBound[j]-leftBound[j]+1));
            }
        }

        return maxArea;

    }
}
