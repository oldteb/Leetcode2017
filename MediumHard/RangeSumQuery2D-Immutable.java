public class NumMatrix {

    int[][] buf;
    int lenX = 0;
    int lenY = 0;
    boolean hasBuf = false;
    
    public NumMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            hasBuf = false;
            return;   
        }
            
        lenX = matrix.length;
        lenY = matrix[0].length;
        buf = new int[lenX][lenY];
        
        for(int i = 0; i < lenX; i++){
            for(int j = 0; j < lenY; j++){
                int tmp1 = i == 0 || j == 0 ? 0 : buf[i-1][j-1];
                int tmp2 = i == 0 ? 0 : buf[i-1][j];
                int tmp3 = j == 0 ? 0 : buf[i][j-1];
                buf[i][j] = tmp2 + tmp3 - tmp1 + matrix[i][j];
            }
        }
        
        hasBuf = true;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(hasBuf == false)  return 0;
        
        int tmp1 = row1 == 0 || col1 == 0 ? 0 : buf[row1-1][col1-1];
        int tmp2 = row1 == 0 ? 0 : buf[row1-1][col2];
        int tmp3 = col1 == 0 ? 0 : buf[row2][col1-1];
        return buf[row2][col2] - tmp2 - tmp3 + tmp1;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */