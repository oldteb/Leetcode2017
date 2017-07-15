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
    public int diameterOfBinaryTree(TreeNode root) {
        TreeNode rst = new TreeNode(0);
         
        dfs(root, rst);
        
        return rst.val;
    }
    
    int dfs(TreeNode root, TreeNode rst){
        if(root == null)  return 0;
        
        int leftDepth = dfs(root.left, rst);
        int rightDepth = dfs(root.right, rst);
        
        int localMaxDiameter = leftDepth + rightDepth;
        rst.val = Math.max(rst.val, localMaxDiameter);
        
        return Math.max(leftDepth+1, rightDepth+1);
    }
}