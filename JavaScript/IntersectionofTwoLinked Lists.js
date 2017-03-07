/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */

/**
 * @param {ListNode} headA
 * @param {ListNode} headB
 * @return {ListNode}
 */
 // take away
 // draw figure to better remind ourself
var getIntersectionNode = function(headA, headB) {
    if(headA == null || headB == null)  return null

    let lenA = 0
    let cursorA = headA
    while(cursorA != null){
        lenA++
        cursorA = cursorA.next
    }

    let lenB = 0
    let cursorB = headB
    while(cursorB != null){
        lenB++
        cursorB = cursorB.next
    }

    cursorA = headA
    cursorB = headB
    if(lenA < lenB){
        for(let i = 0; i < lenB-lenA; i++){
            cursorB = cursorB.next
        }
    }
    else if(lenA > lenB){
        for(let i = 0; i < lenA-lenB; i++){
            cursorA = cursorA.next
        }
    }

    while(cursorA != null && cursorB != null){
        if(cursorA === cursorB)  return cursorA
        cursorA = cursorA.next
        cursorB = cursorB.next
    }

    return null

};
