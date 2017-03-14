/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number} k
 * @return {number}
 */
 // take away
 // the inorder traversal of a BST is a sorted sequence
 // following up:
 // 
var kthSmallest = function(root, k) {
    var list = []
    kthSmallestRecur(root, list, k)

    return list[list.length-1]


};

var kthSmallestRecur = function(root, list, k){
    if(root == null)
        return

    kthSmallestRecur(root.left, list, k)
    if(list.length == k)  return

    list.push(root.val)
    if(list.length == k)  return

    kthSmallestRecur(root.right, list, k)

    return
}
