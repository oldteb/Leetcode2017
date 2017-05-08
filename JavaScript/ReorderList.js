/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @return {void} Do not return anything, modify head in-place instead.
 */
 // solution:
 // step 1: Find list mid point with F&S pointer
 // step 2: Reverse second half
 // step 3: Merge two list

var reorderList = function(head) {
    // step 1: find mid point
    var preMid = findMid(head)
    if(preMid == null)  return

    // step 2: reverse second half
    var head2 = reverseLinkedList(preMid.next)
    preMid.next = null

    // step 3: merge 2 lists
    let turn = 1
    var head1 = head.next
    var tail = head
    while(head1 != null || head2 != null){
        if(turn == 0 && head1 != null){
            var tmp = head1.next
            head1.next = null
            tail.next = head1
            tail = tail.next
            head1 = tmp
        }
        else if(turn == 1 && head2 != null){
            var tmp = head2.next
            head2.next = null
            tail.next = head2
            tail = tail.next
            head2 = tmp
        }

        turn = 1 - turn
    }

    return

};

var findMid = function(head){
    let fast = head
    let slow = head

    if(fast == null)  return null

    while(fast.next != null && fast.next.next != null){
       slow = slow.next
       fast = fast.next.next
    }

    return slow
};

var reverseLinkedList = function(head){
    var newDummy = new ListNode(0)
    while(head != null){
        var tmp = head.next
        head.next = newDummy.next
        newDummy.next = head
        head = tmp
    }

    return newDummy.next
};
