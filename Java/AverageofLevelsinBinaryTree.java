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

Typical BFS probelm.

Refer to note: [Topic] Math
for situations that overflow can cause problem

*/
public class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> avgs = new ArrayList<Double>();
        if(root == null)  return avgs;
        
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        while(queue.size() != 0){
            int size = queue.size();
            long lvlSum = 0;
            
            for(int i = 0; i < size; i++){
                TreeNode node = queue.pop();
                lvlSum =  lvlSum + (long)node.val;
                if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);
            }
            
            avgs.add(lvlSum / (double)size);
        }
        
        return avgs;
    }
    

}