class Solution {
    fun dfs(
        computer: Int,
        graphInfo: HashMap<Int, MutableList<Int>>,
        visited: HashMap<Int, Boolean>
    ) {
        visited[computer] = true
        graphInfo[computer]?.forEach {
            if(visited[it] == null) {
                dfs(it, graphInfo, visited)
            }
        }
    }

    fun makeConnected(n: Int, connections: Array<IntArray>): Int {
        if(connections.size < n - 1) return -1
        val graphInfo = hashMapOf<Int, MutableList<Int>>()
        val visited = hashMapOf<Int, Boolean>()
        var res = -1
        
        connections.forEach { connection ->
            if (graphInfo[connection[0]] == null) {
                graphInfo[connection[0]] = mutableListOf()
                graphInfo[connection[0]]!!.add(connection[1])
            } else {
                graphInfo[connection[0]]!!.add(connection[1])
            }

            if (graphInfo[connection[1]] == null) {
                graphInfo[connection[1]] = mutableListOf()
                graphInfo[connection[1]]!!.add(connection[0])
            } else {
                graphInfo[connection[1]]!!.add(connection[0])
            }
        }
        
        for(i in 0 until n) {
            if(visited[i] == null) {
                res++
                dfs(i, graphInfo, visited)
            }
        }

        return res
    }
}