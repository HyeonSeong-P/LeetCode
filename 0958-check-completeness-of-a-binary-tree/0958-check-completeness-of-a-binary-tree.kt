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
        val queue: Queue<Pair<TreeNode?, Int>> = LinkedList()
        var shouldLeafNode = false
        queue.add(root to 0)
        while(queue.isNotEmpty()) {
            val curr = queue.poll()
            val currNode = curr.first ?: continue
            val currHeight = curr.second 
            when {
                currNode.left != null && currNode.right != null -> {
                    if(shouldLeafNode) return false
                    queue.add(currNode.left to currHeight + 1)
                    queue.add(currNode.right to currHeight + 1)
                }
                currNode.left == null && currNode.right != null -> {
                    return false
                }
                currNode.left == null && currNode.right == null -> {
                    shouldLeafNode = true
                    queue.add(currNode.left to currHeight + 1)
                    queue.add(currNode.right to currHeight + 1)
                }
                else -> {
                    if(shouldLeafNode) return false
                    shouldLeafNode = true
                    queue.add(currNode.left to currHeight + 1)
                    queue.add(currNode.right to currHeight + 1)
                }
            }
        }    
        return true
    }
}