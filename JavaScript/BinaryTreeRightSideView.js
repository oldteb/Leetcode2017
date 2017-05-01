/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[]}
 */
var rightSideView = function(root) {
    var rst = []
    dfs(root, rst, 0)
    return rst
};

var dfs = function(root, rst, lvl){
    if(root == null)
        return

    rst[lvl] = root.val
    dfs(root.left, rst, lvl+1)
    dfs(root.right, rst, lvl+1)
    return
};
