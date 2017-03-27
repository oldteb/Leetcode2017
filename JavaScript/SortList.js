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
 // take away:
 // 1. summarize the template for middle of linked list (refer note for details)
 // 2. only Merge Sort has O(nlg(n)) conplexity in regular sort algorithms
 // 3. O(1) space complexity is achieved by natural of linked lisk
 // 4. dummy is used when assembling new list, like merge process

var sortList = function(head) {
    if(head == null || head.next == null)  return head

    var mid = findMid(head)
    var head2 = mid.next
    mid.next = null
    var newHead1 = sortList(head)
    var newHead2 = sortList(head2)
    return merge(newHead1, newHead2)
};

var merge = function(head1, head2){
    if(head2 == null)  return head1
    if(head1 == null)  return head2

    var dummy = new ListNode(0)
    var tail = dummy

    while(head1 != null && head2 != null){
        if(head1.val <= head2.val){
            tail.next = head1
            head1 = head1.next
        }
        else{
            tail.next = head2
            head2 = head2.next
        }
        tail = tail.next
    }

    // append rest of nodes
    var append = head1
    if(head2 != null)  append = head2
    tail.next = append

    return dummy.next
}

var findMid = function(head){
    let fast = head
    let slow = head

    if(fast == null)  return

    while(fast.next != null && fast.next.next != null){
       slow = slow.next
       fast = fast.next.next
    }

    return slow
}
