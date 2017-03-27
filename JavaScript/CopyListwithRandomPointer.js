/**
 * Definition for singly-linked list with a random pointer.
 * function RandomListNode(label) {
 *     this.label = label;
 *     this.next = this.random = null;
 * }
 */

/**
 * @param {RandomListNode} head
 * @return {RandomListNode}
 */
 // performace: O(n)/O(n)
var copyRandomList = function(head) {
    if(head == null)  return null

    var dummy = new RandomListNode(0)
    var tail = dummy
    var current = head

    var map = new Map()

    while(current != null){
        var nextNode = new RandomListNode(current.label)
        nextNode.random = current.random
        tail.next = nextNode
        tail = tail.next
        map.set(current, nextNode)
        current = current.next
    }

    tail = dummy.next
    while(tail != null){
        tail.random = tail.random == null ? null : map.get(tail.random)
        tail = tail.next
    }

    return dummy.next

};
