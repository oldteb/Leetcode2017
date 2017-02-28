// takeaway
// To find K largest/smallest heap the best data structure
// Performance:
//   - to insert an element into a heap: O(lg(n))
//   - to build a heap from an array: O(nlg(n))
//   - to retrieve top element from heap: O(lg(n))

public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        if(nums == null || nums.length == 0)
            return null;

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i : nums){
            int cnt = map.containsKey(i) ? map.get(i) : 0;
            map.put(i, cnt+1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<Map.Entry<Integer, Integer>>(
            new Comparator<Map.Entry<Integer, Integer>>() {
                public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
                    return e1.getValue() - e2.getValue();
                }
            }
        );

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(queue.size() < k){
                queue.offer(entry);
            }
            else if(entry.getValue() > queue.peek().getValue()){
                queue.poll();
                queue.offer(entry);
            }
        }

        int idx = k-1;
        List<Integer> rst = new ArrayList<Integer>();
        while(queue.size() != 0){
            rst.add(0, queue.poll().getKey());
        }

        return rst;
    }
}
