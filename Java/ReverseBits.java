public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int reversedNum = 0;
        
        for(int i = 0; i < 32; i++){
            reversedNum <<= 1;
            reversedNum |= (n&1);
            n >>= 1;
        }
        
        return reversedNum;
    }
}
