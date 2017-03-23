/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {number[]} preorder
 * @param {number[]} inorder
 * @return {TreeNode}
 */
var buildTree = function(preorder, inorder) {
    if(preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0)
        return []

    var root = dfs(preorder, 0,preorder.length-1, inorder, 0,inorder.length-1)
    return root
};

var dfs = function(preorder, i,j, inorder, x,y){
    if(i > j){
        return null
    }

    var rootVal = preorder[i]
    let mid = -1
    for(let m = x; m <= y; m++){
        if(inorder[m] == rootVal){
            mid = m
            break
        }
    }
    if(mid == -1)  return null

    var root = new TreeNode(rootVal)
    if(mid-x > 0){
        var left = dfs(preorder, i+1, i+1+mid-x-1, inorder, x, mid-1)
        root.left = left
    }
    if(y-mid > 0){
        var right = dfs(preorder, i+mid-x+1, j, inorder, mid+1, y)
        root.right = right
    }

    return root

};
