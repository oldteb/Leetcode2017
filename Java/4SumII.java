public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> sumMap = new HashMap<Integer, Integer>();

        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < B.length; j++){
                int tempSum = A[i] + B[j];
                if(sumMap.containsKey(tempSum)){
                    sumMap.put(tempSum, sumMap.get(tempSum)+1);
                }
                else{
                    sumMap.put(tempSum, 1);
                }
            }
        }

        int count = 0;

        for(int i = 0; i < C.length; i++){
            for(int j = 0; j < D.length; j++){
                int tempSum = 0 - (C[i] + D[j]);
                if(sumMap.containsKey(tempSum)){
                    count += sumMap.get(tempSum);
                }
            }
        }

        return count;


    }
}
