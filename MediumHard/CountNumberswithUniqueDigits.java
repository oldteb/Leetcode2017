// take away:
// count number of certain pattern element in a range
// iterate through the range one by one, count the total number
// find pattern, calculate the number for each level.
public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0)  return 1;
        
        int total = 0;
        int lastCnt = 0;
        
        for(int i = 1; i <= Math.min(n,10); i++){
            if(i == 1){
                lastCnt = 9;
                total = 10;
                continue;
            }
            lastCnt = lastCnt * (10-i+1);
            total += lastCnt;
        }
        
        return total;
    }
}