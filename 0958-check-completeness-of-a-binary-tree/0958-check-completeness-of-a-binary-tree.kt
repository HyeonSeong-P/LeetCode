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
    fun isCompleteTree(root: TreeNode?): Boolean {
        val queue: Queue<TreeNode?> = LinkedList()
        var shouldLeafNode = false
        queue.add(root)
        while(queue.isNotEmpty()) {
            val currNode = queue.poll() ?: continue
            when {
                currNode.left != null && currNode.right != null -> {
                    if(shouldLeafNode) return false
                    queue.add(currNode.left)
                    queue.add(currNode.right)
                }
                currNode.left == null && currNode.right != null -> {
                    return false
                }
                currNode.left == null && currNode.right == null -> {
                    shouldLeafNode = true
                    queue.add(currNode.left)
                    queue.add(currNode.right)
                }
                else -> {
                    if(shouldLeafNode) return false
                    shouldLeafNode = true
                    queue.add(currNode.left)
                    queue.add(currNode.right)
                }
            }
        }    
        return true
    }
}