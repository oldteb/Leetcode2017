public class Solution {
    public int hammingDistance(int x, int y) {
        int humDis = x ^ y;
        int cnt = 0;
        for(int i = 0 ; i < 32; i++){
            cnt += humDis & 0x01;
            humDis >>>= 1;
        }
        return cnt;
    }
}
