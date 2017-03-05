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
 // take-away:
 // 1. '===' is strict equal
 //   a) it return true when both refers to the same object
 // 2. '==' is type-converting equality comparison
 // 0 == false   // true
 // 0 === false  // false, because they are of a different type
 // 1 == "1"     // true, automatic type conversion for value only
 // 1 === "1"    // false, because they are of a different type
 // null == undefined // true
 // null === undefined // false
 // '0' == false // true
 // '0' === false // false
var hasCycle = function(head) {
    if(head == null)  return false
    var slow = head
    var fast = head
    
    while(fast != null && fast.next != null){
        if(slow.next === fast.next.next){
            return true
        }
        slow = slow.next
        fast = fast.next.next
    }
    
    return false
};
