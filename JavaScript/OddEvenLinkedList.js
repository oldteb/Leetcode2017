/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var oddEvenList = function(head) {
    if(head == null)  return head

    // find the last odd node
    let cursor = head
    while(cursor != null){
        if(cursor.next == null || cursor.next.next == null)  break
        cursor = cursor.next.next
    }

    // insert all even nodes to tail
    let oddTail = cursor
    let tail = cursor
    cursor = head
    let cnt = 1
    let lastOdd
    while(cursor != oddTail){
        if(cnt % 2 != 0){
            lastOdd = cursor
            cursor = cursor.next
        }
        else{
            lastOdd.next = cursor.next
            cursor.next = tail.next
            tail.next = cursor
            tail = tail.next
            cursor = lastOdd.next
        }
        cnt++
    }

    return head


};
