/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null)
            return;
        
        TreeLinkNode head = root;
        TreeLinkNode dummy = new TreeLinkNode(0);
        TreeLinkNode last = dummy;

        while(head != null){
            TreeLinkNode curr = head;
            while(curr != null){
                if(curr.left != null){
                    last.next = curr.left;
                    last = curr.left;
                }

                if(curr.right != null){
                    last.next = curr.right;
                    last = curr.right;
                }

                curr = curr.next;
            }

            head = dummy.next;
            dummy.next = null;
            last = dummy;
        }

        return;
    }
}
