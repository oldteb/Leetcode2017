// take away:
// 1. write math equation: 
//    a. number = (n-total digit count of the last level) / number of digits in current level
//    b. digit = (n-total digit count of the last level-1) % number of digits in current level
// 2. Overflow consideration
// 3. when use Math.ceil or Math.floor, make sure use float / double to calculate inside
// 4. remaining calculation is zero based


public class Solution {
    public int findNthDigit(int n) {
        if(n <= 0)  return 0;
        
        int[] digits = new int[11];
        int[] levels = new int[11];
        
        int base = 0;
        int level = 1;
        
        for(int i = 1; i <= 10; i++){
            levels[i] = level;
            int tmp = 9 * i;
            int tmp1 = tmp * level;
            if(level != tmp1 / tmp){
                base = Integer.MAX_VALUE;
                digits[i] = base; 
                break;
            }
            else{
                base += 9 * level * i;
                digits[i] = base;
            }
            level *= 10;
        }
        
        level = 0;
        for(int i = 1; i <= 10; i++){
            if(n <= digits[i]){
                level = i;
                break;
            }
        }
        
        int num = (int)Math.ceil((n - (level == 1 ? 0 : digits[level-1])) / (double)level);
        int rest = (n - (level == 1 ? 0 : digits[level-1]) - 1) % level;
        num = levels[level] + num - 1;
        
        return String.valueOf(num).charAt(rest) - '0';
        
    }
}