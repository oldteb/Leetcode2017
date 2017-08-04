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

reverse in-order treversal of BST tree

*/
public class Solution {
    public TreeNode convertBST(TreeNode root) {
        int curSum = 0;
        
        dfs(root, curSum);
        
        return root;
    }
    
    int dfs(TreeNode root, int curSum){
        if(root == null)  return curSum;
        
        curSum = dfs(root.right, curSum);
        
        root.val = root.val + curSum;
        curSum = root.val;
        
        return dfs(root.left, curSum);
    }
    
}