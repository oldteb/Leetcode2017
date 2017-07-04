/* solution 2 */

// take away
// If the method is called for multiple times
// we can pre-calculate the result and save it
// and then take advantage of pre-calculation for
// calculate method call

public class NumArray {

    int[] nums;
    int[] sumBuf;
    int total;
    
    public NumArray(int[] nums) {
        int sum = 0;
        this.nums = nums;
        sumBuf = new int[nums.length];
        
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            sumBuf[i] = sum;
        }
        total = sum;
        sum = 0;
    }
    
    public int sumRange(int i, int j) {
        if(i<0 || j >= nums.length || i > j)
            return 0;
        return sumBuf[j]-sumBuf[i]+nums[i];
    }
}




/* solution 1 */
/*
public class NumArray {

    public static final int BLOCK_SIZE = 200;
    int[] nums;
    Map<Integer, Integer> cache;
    boolean isEasy = false;
    
    public NumArray(int[] nums) {
        this.nums = nums;
        if(nums.length < BLOCK_SIZE){
            isEasy = true;
            return;
        }
        cache = new HashMap<Integer, Integer>();
        initCache(nums, cache);
    }
    
    public int sumRange(int i, int j) {
        i = Math.max(i,0);
        j = Math.min(j,nums.length-1);
        int left = (int)Math.ceil((float)i/BLOCK_SIZE) * BLOCK_SIZE;
        int right = (int)Math.floor((float)j/BLOCK_SIZE) * BLOCK_SIZE;
        if(isEasy == true || left >= right)
            return getSumRange(i,j+1);

        int sum = 0;
        for(int n = left; n < right; n+=BLOCK_SIZE)
            sum += cache.get(n);
        
        sum += getSumRange(i,left);
        sum += getSumRange(right,j+1);
        
        return sum;
    }
    
    public void initCache(int[] nums, Map<Integer, Integer> cache){
        for(int i = 0; i < nums.length;){
            int toIdx = Math.min(i+BLOCK_SIZE,nums.length);
            int sum = getSumRange(i,toIdx);
            cache.put(i,sum);
            i = toIdx;
        }
    }
    
    public int getSumRange(int from, int to){
        int sum = 0;
        for(int i = from; i < to; i++){
            sum += nums[i];
        }
        return sum;
    }
}
*/
/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
