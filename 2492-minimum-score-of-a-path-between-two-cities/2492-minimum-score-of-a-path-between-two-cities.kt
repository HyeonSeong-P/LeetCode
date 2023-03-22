import kotlin.math.min
class Solution {
    fun minScore(n: Int, roads: Array<IntArray>): Int {
        val graphInfo = hashMapOf<Int, MutableList<Pair<Int, Int>>>()
        roads.forEach { road ->
            if (graphInfo[road[0]] == null) {
                graphInfo[road[0]] = mutableListOf()
                graphInfo[road[0]]!!.add(road[1] to road[2])
            } else {
                graphInfo[road[0]]!!.add(road[1] to road[2])
            }

            if (graphInfo[road[1]] == null) {
                graphInfo[road[1]] = mutableListOf()
                graphInfo[road[1]]?.add(road[0] to road[2])
            } else {
                graphInfo[road[1]]!!.add(road[0] to road[2])
            }
        }


        var minScore = 10001
        val queue: Queue<Pair<Int, Int>> = LinkedList()
        graphInfo[1]?.forEach {
            queue.add(it)
        }
        while (queue.isNotEmpty()) {
            val (city, distance) = queue.poll()
            minScore = min(minScore, distance)
            while (graphInfo[city]?.isNotEmpty() == true) {
                val path = graphInfo[city]?.removeAt(0)
                queue.add(path)
            }
        }
        return minScore
    }
}