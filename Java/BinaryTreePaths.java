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
    
    // Solution 1: clean DFS
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> rst = new LinkedList<String>();
        
        if(root == null)  return rst;
        
        if(root.left == null && root.right == null){
            rst.add(root.val+"");
            return rst;
        }
        
        for(String path : binaryTreePaths(root.left)){
            rst.add(root.val + "->" + path);
        }
        
        for(String path : binaryTreePaths(root.right)){
            rst.add(root.val + "->" + path);
        }
        
        return rst;
    }
    
//     // Solution 2: DFS + result save 
//     public List<String> binaryTreePaths(TreeNode root) {
//         if(root == null){
//             return new ArrayList<String>();
//         }
        
//         List<String> rst = new ArrayList<String>();
//         List<TreeNode> buf = new ArrayList<TreeNode>();
        
//         buf.add(root);
//         dfs(root, rst, buf);
        
//         return rst;
//     }
    
//     void dfs(TreeNode root, List<String> rst, List<TreeNode> buf){
//         if(root.left == null && root.right == null){
//             rst.add(getExpression(buf));
//             return;
//         }       
        
//         if(root.left != null){
//             buf.add(root.left);
//             dfs(root.left, rst, buf);
//             buf.remove(buf.size()-1);
//         }
        
//         if(root.right != null){
//             buf.add(root.right);
//             dfs(root.right, rst, buf);
//             buf.remove(buf.size()-1);
//         }
        
//         return;
//     }
    
//     String getExpression(List<TreeNode> buf){
//         StringBuilder sb = new StringBuilder();
        
//         for(int i = 0; i < buf.size(); i++){
//             sb.append(String.valueOf(buf.get(i).val));
//             if(i != buf.size()-1)
//                 sb.append("->");
//         }
        
//         return sb.toString();
//     }
}