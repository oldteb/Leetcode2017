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
 // take-away
 // when use iteration to solve recurrsive problem
 // use stack to imitate the process
var inorderTraversal = function(root) {
    if(root == null){
        return []
    }

    // solution 1
    // var leftList = inorderTraversal(root.left)
    // leftList.push(root.val)
    // var rightList = inorderTraversal(root.right)
    // return leftList.concat(rightList)

    // solution 2: iteration
    var stack = []
    var currentNode = root
    while(currentNode != null){
        stack.push(currentNode)
        currentNode = currentNode.left
    }

    var rst = []
    while(stack.length != 0){
        var node = stack.pop()
        rst.push(node.val)

        var rightNode = node.right
        while(rightNode != null){
            stack.push(rightNode)
            rightNode = rightNode.left
        }
    }

    return rst

};
