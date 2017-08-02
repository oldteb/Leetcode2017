/*
-- Take Away --

For sparce matrix, ues a compact 2 dimension list to represent.

use cell additive logic to calculate.

*/

public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        if(A == null || A.length == 0 || A[0].length == 0
          || B == null || B.length == 0 || B[0].length == 0)
            return new int[0][0];
        
        int[][] rst = new int[A.length][B[0].length];
        
        
        // solution 1: O(1) space
        int m = A.length, n = A[0].length, nB = B[0].length;

        for(int i = 0; i < m; i++) {
            for(int k = 0; k < n; k++) {
                if (A[i][k] != 0) {
                    for (int j = 0; j < nB; j++) {
                        rst[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
        }
        
        // solution 2: O(j) space
//         List<List<Integer>> list = new ArrayList<List<Integer>>();
        
//         for(int j = 0; j < B[0].length; j++){
//             List<Integer> ls = new ArrayList<Integer>();
//             for(int i = 0; i < B.length; i++){
//                 if(B[i][j] != 0){
//                     ls.add(i);
//                 }
//             }
//             list.add(ls);
//         }
        
//         for(int i = 0; i < A.length; i++){
//             for(int j = 0; j < B[0].length; j++){
//                 List<Integer> ls = list.get(j);
//                 int sum = 0;
//                 for(int k = 0; k < ls.size(); k++){
//                     sum += A[i][ls.get(k)] * B[ls.get(k)][j];
//                 }
                
//                 rst[i][j] = sum;
//             }
//         }
        
        return rst;
    }

}