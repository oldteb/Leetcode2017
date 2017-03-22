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
 // take away:
 // 1. zigzag traversal keywords: stack + BFS
var zigzagLevelOrder = function(root) {
    if(root == null)
        return[]

    // init
    var stack = []
    let lvl = 0
    stack.push(root)
    var rst = []

    while(stack.length != 0){
        let size = stack.length
        var lvlList = []
        var lvlStack = []
        for(let i = 0; i < size; i++){
            var node = stack.pop()
            lvlList.push(node.val)
            if(lvl%2 == 0){
                if(node.left != null) lvlStack.push(node.left)
                if(node.right != null) lvlStack.push(node.right)
            }
            else{
                if(node.right != null) lvlStack.push(node.right)
                if(node.left != null) lvlStack.push(node.left)
            }
        }
        stack = lvlStack
        rst.push(lvlList)
        lvl++
    }

    return rst
};
