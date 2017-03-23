/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @param {TreeNode} p
 * @param {TreeNode} q
 * @return {TreeNode}
 */
var lowestCommonAncestor = function(root, p, q) {
    if(root == null || p == null || q == null)
        return null
    var traceP = []
    var traceQ = []

    getTrace(root, p, traceP)
    getTrace(root, q, traceQ)

    let i = 1
    for(; i < Math.min(traceP.length, traceQ.length); i++){
        if(traceP[i] !== traceQ[i])  break
    }

    return traceP[i-1]
};

var getTrace = function(root, target, trace){
    if(root == null)  return false

    trace.push(root)
    if(root === target)  return true

    if(getTrace(root.left, target, trace))  return true
    if(getTrace(root.right, target, trace))  return true

    trace.splice(trace.length-1,1)
    return false
};
