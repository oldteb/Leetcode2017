/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var mergeTwoLists = function(l1, l2) {
    var dummyee = new ListNode(0)
    var tail = dummyee

    while(l1 != null && l2 != null){
        if(l1.val < l2.val){
            tail.next = l1
            l1 = l1.next
        }
        else{
            tail.next = l2
            l2 = l2.next
        }

        tail = tail.next
        tail.next = null
    }

    var llist = l1 == null ? l2 : l1
    while(llist != null){
        tail.next = llist
        llist = llist.next
        tail = tail.next
        tail.next = null
    }

    return dummyee.next

};
