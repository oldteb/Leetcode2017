// take away:
// good practice for map and stack
// map is used for create relationship
// stack is fot reverse resolve

public class Solution {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int num : nums){
            while(stack.size() != 0 && stack.peek() < num){
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        
        int[] rst = new int[findNums.length];
        
        for(int i = 0; i < findNums.length; i++){
            int n = findNums[i];
            rst[i] = map.containsKey(n) ? map.get(n) : -1;
        }
        
        return rst;
    }
}