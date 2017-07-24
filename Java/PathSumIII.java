/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// take away:
// use dfs for tree treversal
// for each node, add all possible paths from root to current node.
// use hashmap to store previous value, so we only need O(1) to find the path.
//
// tricks:
// just like 2 sum, we can use map to find previous calculated value in O(1)
// 
public class Solution {
    public int pathSum(TreeNode root, int sum) {
        int paths = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0,1);
        
        return dfs(root, 0, map, paths, sum);
    }
    
    int dfs(TreeNode node, int curSum, Map<Integer, Integer> map, int paths, int target){
        if(node == null)  return paths;
        
        int newCurSum = curSum + node.val;
        int curSumCnt = map.containsKey(newCurSum) ? map.get(newCurSum) : 0;
        map.put(newCurSum, curSumCnt+1);
        
        int newPaths = paths;
        if(map.containsKey(newCurSum - target) && map.get(newCurSum - target) > 0){
            if(target == 0)
                newPaths = map.get(newCurSum - target) - 1 + paths;
            else
                newPaths = map.get(newCurSum - target) + paths;
        }
        
        newPaths = dfs(node.left, newCurSum, map, newPaths, target);
        newPaths = dfs(node.right, newCurSum, map, newPaths, target);
        
        map.put(newCurSum, curSumCnt);
        
        return newPaths;
    }
}