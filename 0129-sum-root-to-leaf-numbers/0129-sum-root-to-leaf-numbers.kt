import kotlin.math.*
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
    var sum = 0
    val list = mutableListOf<Int>()

    fun getRootToLeaf(): Int = 
        if(list.isNotEmpty()) list.reversed().reduceIndexed { index, total, value ->
            total + (10.0).pow(index).toInt() * value
        }
        else 0

    fun dfs(node: TreeNode?) {
        if(node == null) return
        list.add(node!!.`val`)
        if(node?.left == null && node?.right == null) {
            sum += getRootToLeaf()   
            list.removeAt(list.size - 1)
            return
        }
        dfs(node?.left)
        dfs(node?.right)
        list.removeAt(list.size - 1)
    }

    fun sumNumbers(root: TreeNode?): Int {
        dfs(root)
        return sum
    }
}