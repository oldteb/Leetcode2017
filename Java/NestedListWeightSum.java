/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        // solution 1: Iteration
        Stack<NestedInteger> stack = new Stack<NestedInteger>();
        Stack<Integer> levels = new Stack<Integer>();
        
        pushListToStack(stack, levels, nestedList, 1);
        
        int sum = 0;
        
        while(stack.size() > 0){
            NestedInteger cur = stack.pop();
            int level = levels.pop();
            if(cur.isInteger()){
                sum += cur.getInteger() * level;
            }
            else{
                List<NestedInteger> subList = cur.getList();
                pushListToStack(stack, levels, subList, level+1);
            }
        }
        
        return sum;

        // solution 2: Recurrsive
        // return dfs(nestedList, 1);
        
    }
    
    
    
    void pushListToStack(Stack<NestedInteger> stack, Stack<Integer> levels, List<NestedInteger> nestedList, int level){
        for(int i = nestedList.size()-1; i >= 0; i--){
            stack.push(nestedList.get(i));
            levels.push(level);
        }
    }
    
    
    public int dfs(List<NestedInteger> nestedList, int level){
        if(nestedList == null || nestedList.size() == 0)  return 0;
        int sum = 0;
        for(int i = 0; i < nestedList.size(); i++){
            if(nestedList.get(i).isInteger())
                sum += nestedList.get(i).getInteger() * level;
            else
                sum += dfs(nestedList.get(i).getList(), level+1);
        }
        
        return sum;
    }
}