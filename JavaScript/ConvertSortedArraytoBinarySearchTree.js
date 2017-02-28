/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {number[]} nums
 * @return {TreeNode}
 */
var sortedArrayToBST = function(nums) {
    if(nums == null || nums.length == 0)
        return null

    return sortedArrayToBSTRec(nums, 0, nums.length-1)
};

var sortedArrayToBSTRec = function(nums, i, j){
    if(i == j)  return new TreeNode(nums[i])
    else if(i > j) return null

    let mid = Math.ceil((i + j)/2)

    var root = new TreeNode(nums[mid])
    root.left = sortedArrayToBSTRec(nums, i , mid-1)
    root.right = sortedArrayToBSTRec(nums, mid+1, j)

    return root
}
