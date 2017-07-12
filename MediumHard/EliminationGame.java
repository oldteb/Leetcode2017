public class Solution {
    public int lastRemaining(int n) {
        if(n < 2)
            return 1;
        
        int size = n;
        int turn = 0;
        int head = 1;
        int steps = 1;
        
        while(size > 1){
            if(turn == 0 || size%2 != 0)
                head += steps;
            
            steps *= 2;
            size = size/2;
            turn = 1-turn;
        }
        
        return head;
    }
}