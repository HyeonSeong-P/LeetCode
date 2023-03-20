class Solution {
    fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
        val flowerbedSize = flowerbed.size
        var maxNumber = 0
        if(flowerbedSize == 1) {
            if(flowerbed[0] == 0) maxNumber++
            return n <= maxNumber
        }
        if(flowerbed[0] == 0 && flowerbed[1] == 0) {
            flowerbed[0] = 1
            maxNumber++
        }
        for(i in 1 until flowerbedSize - 1) {
            if(flowerbed[i - 1] == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                flowerbed[i] = 1
                maxNumber++
            }
        }
        if(flowerbed[flowerbedSize - 1] == 0 && flowerbed[flowerbedSize - 2] == 0) {
            maxNumber++
        }
        return n <= maxNumber
    }
}