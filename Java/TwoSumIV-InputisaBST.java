/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {    
    // solution 1: DFS+SET(O(n)/O(n))
//     public boolean findTarget(TreeNode root, int k) {
//         Set<Integer> set = new HashSet<Integer>();
//         return dfs(root, set, k);
//     }
    
//     boolean dfs(TreeNode root, Set<Integer> set, int k){
//         if(root == null) return false;
        
//         if(set.contains(k-root.val))  return true;
//         else{
//             set.add(root.val);
//             if(dfs(root.left, set, k) == true)  return true;
//             if(dfs(root.right, set, k) == true)  return true;
//             return false;  
//         } 
//     }
    
    // solution 2: DFS+STACK: O(n)/O(lg(n))
    public boolean findTarget(TreeNode root, int k) {
        Stack<TreeNode> stackL = new Stack<TreeNode>();
        Stack<TreeNode> stackR = new Stack<TreeNode>();
        
        for(TreeNode cur = root; cur != null; cur = cur.left)  
            stackL.push(cur);
        for(TreeNode cur = root; cur != null; cur = cur.right)  
            stackR.push(cur);
            
        while(stackL.size() != 0 && stackR.size() != 0 && stackL.peek() != stackR.peek()){
            int tmpSum = stackL.peek().val + stackR.peek().val;
            if(tmpSum == k)  return true;
            else if(tmpSum < k)
                for(TreeNode cur = stackL.pop().right; cur != null; cur = cur.left) 
                    stackL.push(cur);
            else
                for(TreeNode cur = stackR.pop().left; cur != null; cur = cur.right) 
                    stackR.push(cur);
        }
        
        return false;
    }
    
    // solution 3: convert BST to sorted array: O(n)/O(n)
    // solution 4: for each node, do search in BST: O(nlg(n))
}