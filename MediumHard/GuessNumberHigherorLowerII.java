// take away:
// think problem in DP way:
// 1) determin the problem is looking for optimal solution
// 2) define recurrsive equation
// 3) consider different form of the dp:
//    a) one dimension dp F(n)
//    b) multiple one dimensin dp F(n), D(n)
//    c) two dimension dp F(i,j)

public class Solution {
    public int getMoneyAmount(int n) {
        if(n == 1)  return 0;
        
        int[][] matrix = new int[n+1][n+1];
        
        for(int i = 0; i < n; i++){
            for(int j = 1; j <= n-i; j++){
                if(i == 0){
                    matrix[j][j+i] = 0;
                    continue;   
                }
                int min = Integer.MAX_VALUE;
                for(int k = j; k <= j+i; k++){
                    int left = k == j ? 0 : matrix[j][k-1];
                    int right = k == j+i ? 0 : matrix[k+1][j+i];
                    min = Math.min(min, k + Math.max(right,left));
                }
                matrix[j][j+i] = min;
                System.out.println(j + ", " + (j+i) + ", " + min);
            }
        }
        
        return matrix[1][n];
        
    }
}