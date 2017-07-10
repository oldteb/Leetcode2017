// take away
// Performance Optimization:
// 1. do not use if clause
// 2. use bit-operator as much as possible

public class Solution {
    public int findComplement(int num) {
        int compNum = 0;
        int shift = 0;
        
        while(num != 0){
            int bit = 1-(num & 0x01);
            compNum |=  bit << shift;
            shift++;
            num >>= 1;
        }
        
        return compNum;
    }
}