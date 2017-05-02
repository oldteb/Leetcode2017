/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {ListNode} head
 * @return {TreeNode}
 */

 // take away
 // ref to note: [Template] Middle Node in Linked List

var sortedListToBST = function(head) {
    if(head == null)
        return null
    if(head.next == null)
        return new TreeNode(head.val)

    var dummy = new ListNode(0)
    dummy.next = head
    var slow = dummy
    var fast = head

    while(fast != null && fast.next != null){
        slow = slow.next
        fast = fast.next.next
    }

    var mid = slow.next
    slow.next = null
    var right = mid.next
    mid.next = null

    var left = sortedListToBST(head)
    right = sortedListToBST(right)

    var root = new TreeNode(mid.val)
    root.left = left
    root.right = right

    return root

};
