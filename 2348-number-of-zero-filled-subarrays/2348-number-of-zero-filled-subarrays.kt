class Solution {
    fun getSubArrayNum(num: Long) = (1 + num) * num / 2
    fun zeroFilledSubarray(nums: IntArray): Long {
        var zeroSequenceList = mutableListOf<Int>()
        var zeroSequence = 0
        nums.forEach {
            if (it == 0) {
                zeroSequence++
            } else {
                zeroSequenceList.add(zeroSequence)
                zeroSequence = 0
            }
        }
        if(nums.last() == 0) zeroSequenceList.add(zeroSequence)
        print(zeroSequenceList)
        return zeroSequenceList.map { getSubArrayNum(it.toLong()) }.sum()
    }
}