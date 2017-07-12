public class Solution {
    public boolean isPowerOfFour(int num) {
        int n = num;
        for(int i = 0; i < 32; i++){
            if(i%2 == 0){
                if((n & 0x01) == 1){
                    n >>= 1;
                    return n == 0 ? true : false;
                }
            }
            else{
                if((n & 0x01) == 1) return false;
            }
            n >>= 1;
        }
        
        return false;
    }
}