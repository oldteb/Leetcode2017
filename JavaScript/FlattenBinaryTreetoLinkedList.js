/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {void} Do not return anything, modify root in-place instead.
 */
var flatten = function(root) {
    if(root == null)
        return

    // flatten vertically
    dfs(root)

    // flatten by level
    // var queue = []
    // if(root.left != null) queue.push(root.left)
    // if(root.right != null) queue.push(root.right)
    // root.left = null
    // var listTail = root
    // // BFS
    // while(queue.length > 0){
    //     let len = queue.length
    //     for(let i = 0; i < len; i++){
    //         var node = queue.shift()
    //         if(node.left != null) queue.push(node.left)
    //         if(node.right != null) queue.push(node.right)
    //         node.left = null
    //         listTail.right = node
    //         listTail = node
    //     }
    // }
    // listTail.right = null
    // return
};

var dfs = function(root){
    if(root == null)  return null
    var tail1 = dfs(root.left)
    var tail2 = dfs(root.right)

    if(tail1 == null && tail2 == null){
        return root
    }
    else if(tail1 != null && tail2 == null){
        root.right = root.left
        root.left = null
        return tail1
    }
    else if(tail1 == null && tail2 != null){
        return tail2
    }
    else{
        var tmp = root.right
        root.right = root.left
        root.left = null
        tail1.right = tmp
        return tail2
    }
};
