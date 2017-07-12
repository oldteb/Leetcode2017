public class MovingAverage {

    LinkedList<Integer> queue;
    int windowSize;
    int sum = 0;
    
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        queue = new LinkedList<Integer>();
        windowSize = size;
        sum = 0;
    }
    
    public double next(int val) {
        if(queue.size() == windowSize){
            int num = queue.poll();
            sum -= num;
        }
        
        queue.offer(val);
        sum += val;
        return ((double)sum)/queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */