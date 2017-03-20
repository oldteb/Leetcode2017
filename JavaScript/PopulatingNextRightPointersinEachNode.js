/**
 * Definition for binary tree with next pointer.
 * function TreeLinkNode(val) {
 *     this.val = val;
 *     this.left = this.right = this.next = null;
 * }
 */
/**
 * @param {TreeLinkNode} root
 * @return {void} Do not return anything, modify tree in-place instead.
 */
// take away
// with next fields setted up in all upper level nodes
// we do not need queue to store level node to do BFS.
//
// analysis:
// 1) since the O(1) space only, we consider:
//    a) bit manipulation
//    b) reccurrsive
//    c) greedy
// 2) since its tree problem, we consider
//    a) DFS
//    b) BFS
var connect = function(root) {
    if(root == null)
        return

    var levelHead = root

    while(levelHead.left != null){  // new level
        var currentNode = levelHead
        var lastNode = levelHead

        while(currentNode != null){
            if(currentNode !== lastNode){
                lastNode.right.next = currentNode.left
            }

            currentNode.left.next = currentNode.right

            lastNode = currentNode
            currentNode = currentNode.next
        }

        lastNode.right.next = null


        levelHead = levelHead.left
    }

    return
};
