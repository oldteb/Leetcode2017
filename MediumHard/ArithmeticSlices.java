public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A == null || A.length < 3)
            return 0;

        int cnt = 0;
        int curDiff = A[1] - A[0];
        int curLen = 1;
        
        for(int i = 2; i < A.length; i++){
            if(A[i] - A[i-1] == curDiff){
                curLen++;
                cnt += (curLen-1);
            }
            else{
                curLen = 1;
                curDiff = A[i] - A[i-1];
            }
        }
        
        return cnt;
    }
}