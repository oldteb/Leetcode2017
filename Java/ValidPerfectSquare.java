public class Solution {
    public boolean isPerfectSquare(int num) {
        double i = 1;
        while(i < num/i)  i = i + 1;
        return i == num/i ? true : false;
    }
}