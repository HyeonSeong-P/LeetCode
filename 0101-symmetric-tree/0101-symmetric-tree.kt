/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun compareTreeNode(left: TreeNode?, right: TreeNode?): Boolean = 
        when{
                left == null && right == null -> true
                left?.`val` != right?.`val` -> false
                else -> compareTreeNode(left?.right, right?.left) && compareTreeNode(left?.left, right?.right)
            }
            
    fun isSymmetric(root: TreeNode?): Boolean = compareTreeNode(root?.left, root?.right)
}