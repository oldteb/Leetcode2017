/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*
-- Take Away --

1. Every Tree problem is a DP/greedy problem:
    F(root tree) = recurrsive equatiion(F(left subtree), F(right subtree))

2. to return multiple parameter from recurrsive function:
    a. defined inner class
    b. use array / List
    c. define global primitive variable
*/
public class Solution {
    public int countUnivalSubtrees(TreeNode root) {
        int[] count = new int[1];
        
        dfs(root, count);
        
        return count[0];
        
    }
    
    boolean dfs(TreeNode root, int[] count){
        if(root == null)  return true;
        
        boolean f1 = dfs(root.left, count);
        boolean f2 = dfs(root.right, count);
        
        if((root.left == null || root.val == root.left.val)
               && (root.right == null || root.val == root.right.val)
                && f1 && f2){
            count[0]++;
            return true;
        }
        
        return false; 
    }

}