/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[][]}
 */
 // take away
 // queue in javascript:
 // var queue = []
 // queue.push(1)
 // var val = queue.shift()
 // console.log(val)  // print '1'
var levelOrder = function(root) {
    if(root == null){
        return []
    }

    var rst = []
    var queue = []
    queue.push(root)
    var size = queue.length

    while(queue.length != 0){
        var lvlList = []
        for(let i = 0; i < size; i++){
            var tnode = queue.shift()
            lvlList.push(tnode.val)
            if(tnode.left != null)  queue.push(tnode.left)
            if(tnode.right != null)  queue.push(tnode.right)
        }
        rst.push(lvlList)
        size = queue.length
    }

    return rst
};
