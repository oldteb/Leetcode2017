/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} n
 * @return {ListNode}
 */
var removeNthFromEnd = function(head, n) {
    if(head == null || n <= 0)
        return head

    var dummy = new ListNode(0)
    dummy.next = head
    var fast = head
    var slow = dummy
    let cnt = 0

    while(fast.next != null){
        fast = fast.next
        if(++cnt >= n){
            slow = slow.next
        }
    }

    if(slow.next != null){
        slow.next = slow.next.next
    }

    return dummy.next

};
