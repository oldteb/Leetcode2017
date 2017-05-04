/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} m
 * @param {number} n
 * @return {ListNode}
 */
var reverseBetween = function(head, m, n) {
    if(head == null)
        return null
    if(m == n)
        return head

    var dummy1 = new ListNode(0)
    var dummy2 = new ListNode(0)

    dummy1.next = head
    var cursor = dummy1
    var tail = dummy2.next
    let idx = 1

    while(idx < m){
        cursor = cursor.next
        idx++
    }

    while(idx <= n){
        var node = cursor.next
        cursor.next = cursor.next.next

        var tmp = dummy2.next
        dummy2.next = node
        node.next = tmp
        if(tail == null)
            tail = node

        idx++
    }

    var tmp = cursor.next
    cursor.next = dummy2.next
    tail.next = tmp

    return dummy1.next

};
