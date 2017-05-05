/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
 // time complexity: O(lg(n) * lg(n))
var countNodes = function(root) {
    if(root == null)
        return 0

    let cntLeft = countDepth(root, 0)
    let cntRight = countDepth(root, 1)

    if(cntLeft == cntRight)  return Math.pow(2,cntLeft)-1

    return countNodes(root.left) + countNodes(root.right) + 1
};

var countDepth = function(root, leftOrRight){
    if(root == null)  return 0
    if(leftOrRight == 0)  return countDepth(root.left, 0) + 1
    else return countDepth(root.right, 1) + 1
};
