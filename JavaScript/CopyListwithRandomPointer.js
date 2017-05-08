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

 // solution 1: 2-pass O(n)/O(n): Map old node to new node
 // solution 2: 1-pass O(n)/O(n): Map old node to new node, constrcut new node when not existed in map
 // solution 3: O(n)/O(1): old node next point to new node, new node random point to old node
var copyRandomList = function(head) {
    if(head == null)  return null

    // solution 1
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
