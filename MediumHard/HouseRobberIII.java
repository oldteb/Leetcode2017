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
    public int rob(TreeNode root) {
        if(root == null)  return 0;
        
        MyTuple tp = dfs(root);
        
        return Math.max(tp.inclusive, tp.exclusive);
    }
    
    MyTuple dfs(TreeNode root){
        MyTuple tp = new MyTuple(0,0);
        if(root == null)  return tp;
        
        MyTuple left = dfs(root.left);
        MyTuple right = dfs(root.right);
        
        int inclusive = left.exclusive + right.exclusive + root.val;
        int exclusive = Math.max(left.inclusive, left.exclusive) + Math.max(right.inclusive, right.exclusive);
        
        return new MyTuple(inclusive, exclusive);
    }
    
    class MyTuple{
        
        int inclusive;
        int exclusive;
        
        MyTuple(int inclusive, int exclusive){
            this.inclusive = inclusive;
            this.exclusive = exclusive;
        }
    }
}