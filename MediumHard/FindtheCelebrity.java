/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

/*
-- Take Away --

It is hard to tell who is the celebrity, but is easy to tell who are not.
every time knows(A,B) is called, we know either A or B is not celecrity:
    if return true, then A is not celebrity
    if return false, then B is not celebrity

So by calling it for n-1 timns, we left one candidate who is possiblly to be celebrity.
Then iterate array again to make sure if the candidate is celebrity.

Review:
    start with small scale. Think about: if there is only 2 how many needed, what about 3 people.

*/
public class Solution extends Relation {
    public int findCelebrity(int n) {
        if(n == 0)  return -1;
        
        // solution 1: naive O(n^2)
        // LinkedList<Integer> queue = new LinkedList<Integer>();
        // for(int i = 0; i < n; i++)
        //     queue.offer(i);
        // for(int i = 0; i < n; i++){
        //     int size = queue.size();
        //     if(size == 0)  return -1;
        //     for(int j = 0; j < size; j++){
        //         int ppl = queue.poll();
        //         if(ppl == i){
        //             queue.offer(ppl);
        //         }
        //         else if(knows(ppl,i) == false && knows(i,ppl) == true)
        //             queue.offer(ppl);
        //     }
        // }
        // return queue.size() == 1 ? queue.poll() : -1;
        
        // solution 2: O(n)
        int candidate = 0;
        for(int i = 1; i < n; i++){
            if(knows(candidate,i)){
                candidate = i;
            }
        }
        
        for(int i = 0; i < n; i++){
            if(i == candidate)  continue;
            if(!knows(i,candidate) || knows(candidate, i))  return -1;
        }
        
        return candidate;
        
    }
}