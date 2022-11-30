class Solution {
  fun uniqueOccurrences(arr: IntArray): Boolean {
    val map = arr.groupBy { it }
      .map { it.value.size }

    val set = map.toSet()
    
    return set.size == map.size
  }
}