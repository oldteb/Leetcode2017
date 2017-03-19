public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k > nums.length){
            return -1;
        }

        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b){
                if(a < b){
                    return 1;
                }
                else if(a > b){
                    return -1;
                }
                else
                    return 0;
            }
        });

        for(int i : nums){
            heap.offer(i);
        }

        int rst = 0;
        for(int i = 0; i < k; i++){
            rst = heap.poll();
        }

        return rst;

    }
}
