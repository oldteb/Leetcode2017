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
var isSymmetric = function(root) {
    if(root == null)  return true

    // solution 1: recurrsion
    // return isSymmetricRec(root.left, root.right)

    // solution 2: BFS
    var queue = []
    queue.push(root)
    let size = 1
    while(queue.length != 0){
        var stack = []
        // isVal = false
        for(let i = 0; i < size; i++){
            var node = queue.shift()
            if(size != 1){
                if(i < Math.floor(size/2)){
                    stack.push(node)
                }
                else{
                    var mirrorNode = stack.pop()
                    if(mirrorNode == null && node == null){}
                    else if(mirrorNode == null || node == null)
                        return false
                    else if(mirrorNode.val != node.val)
                        return false
                }
            }
            if(node == null) continue
            queue.push(node.left)
            queue.push(node.right)
        }
        size = queue.length
    }

    return true


};

// solution 2 recur
var isSymmetricRec = function(left, right){
    if(left == null && right == null)  return true
    else if(left == null || right == null)  return false

    if(left.val != right.val)  return false

    if(isSymmetricRec(left.left, right.right) == false)  return false
    if(isSymmetricRec(left.right, right.left) == false)  return false

    return true
}
