public class Solution {
    public boolean isSelfCrossing(int[] x) {
        if(x == null || x.length <= 3)
        	return false;
        
        int[] dimension = {x[0],x[1]};  // height, width
        int[] extra = {x[0],x[1]};  // height, width
        int turn = 0;
        int cursor = 2;
        
        // phase 1
        while(cursor < x.length && x[cursor] > dimension[turn]){
        	extra[turn] = x[cursor] - dimension[turn];
        	dimension[turn] = x[cursor];
        	cursor++;
        	turn = 1-turn;
        }
        if(cursor == x.length)  return false;
        
        // transition
        dimension[turn] = x[cursor];
        if(x[cursor] >= extra[turn]){
        	dimension[1-turn] = extra[1-turn];
        }
        cursor++;
    	turn = 1-turn;
        
        // phase 2
        while(cursor < x.length){
        	if(x[cursor] >= dimension[turn]){
        		return true;
        	}
        	dimension[turn] = x[cursor];
        	cursor++;
        	turn = 1-turn;
        }

        return false;
    }
}
