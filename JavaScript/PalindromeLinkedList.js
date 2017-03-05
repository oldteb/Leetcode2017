/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @return {boolean}
 */
 // take-away
 // when there is O(1) space requirement
 // always consider to modify given input (array, linkedlist, etc.)
var isPalindrome = function(head) {
    if(head == null)  return true  // len == 0
    let slow = head
    let fast = head

    while(fast != null && fast.next != null){
        slow = slow.next
        fast = fast.next.next
    }

    if(slow == head)  return true  // len == 1
    let mid = slow
    let tail = mid
    let reverse = mid.next
    mid.next = null
    while(reverse != null){
        let newReverse = reverse.next
        reverse.next = tail
        tail = reverse
        reverse = newReverse
    }

    while(tail != null){
        if(head == null)  return false
        else if(head.val != tail.val)  return false
        head = head.next
        tail = tail.next
    }

    return true




};
