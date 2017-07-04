/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        if(n == 1)
            return 1;
        
        int left = 1;
        int right = n;
        while(left < right){
            int mid = (right-left)/2+left;
            int rst = guess(mid);
            if(rst == 0)
                return mid;
            else if(rst == 1)
                left = mid + 1;
            else
                right = mid;
        }
        
        return left;
    }
}
