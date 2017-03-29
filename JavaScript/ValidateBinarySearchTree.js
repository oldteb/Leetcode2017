/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {boolean}
 */
 // take away:
 // basic data structure property
 // in-order treversal is ascending <==> valid binary search tree
var isValidBST = function(root) {
    if(root == null)  return true
    var rst = []

    inorderTreversal(root, rst)

    for(let i = 0; i < rst.length-1; i++){
        if(rst[i] >= rst[i+1])  return false
    }

    return true

};

var inorderTreversal = function(root, rst){
    if(root == null)  return

    inorderTreversal(root.left, rst)
    rst.push(root.val)
    inorderTreversal(root.right, rst)

    return
};
