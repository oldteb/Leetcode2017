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
var reverseList = function(head) {
    if(head == null || head.next == null)
        return head

     var newHead = null

    // solution 1: use stack O(n)/O(n)
    // var stack = []
    // var cursor = head
    // while(cursor != null){
    //     stack.push(cursor)
    //     cursor = cursor.next
    // }
    // newHead = cursor = stack.pop()
    // while(stack.length != 0){
    //     var node = stack.pop()
    //     node.next = null
    //     cursor.next = node
    //     cursor = cursor.next
    // }

    // solution 2: Insert at new list head O(1)/O(1)
    // newHead = null
    // var cursor = head
    // while(cursor != null){
    //     var temp = cursor.next
    //     cursor.next = newHead
    //     newHead = cursor
    //     cursor = temp
    // }

    // solution 3: recurssive O(n)
    var rst = reverseRec(head)
    rst.tail.next = null
    newHead = rst.head


    return newHead

};

// solution 3 rec function
var reverseRec = function(head){
    if(head == null)
        return {
            tail: null,
            head: null
        }
    // head.next = null
    var rst = reverseRec(head.next)
    if(rst.head == null){
        rst.head = rst.tail = head
    }
    else{
        rst.tail.next = head
    }

    return {
        tail: head,
        head: rst.head
    }

}
