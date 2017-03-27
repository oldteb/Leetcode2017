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
var addTwoNumbers = function(l1, l2) {
    if(l1 == null || l2 == null)  return null

    let carry = 0
    var dummy = new ListNode(0)
    var tail = dummy

    while(l1 != null || l2 != null){
        let num1 = 0
        let num2 = 0
        if(l1 != null){
            num1 = l1.val
            l1 = l1.next
        }
        if(l2 != null){
            num2 = l2.val
            l2 = l2.next
        }

        let digit = (num1+num2+carry)%10
        carry = Math.floor((num1+num2+carry)/10)

        var newNode = new ListNode(digit)
        tail.next = newNode
        tail = tail.next
    }

    if(carry == 1){
        tail.next = new ListNode(1)
    }

    return dummy.next
};
