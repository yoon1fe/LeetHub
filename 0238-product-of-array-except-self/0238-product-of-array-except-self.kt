class Solution {
  fun productExceptSelf(nums: IntArray): IntArray {
    var answer = IntArray(nums.size)

    var prefixProduct = 1
    for (i in 0 until nums.size) {
      answer[i] = prefixProduct
      prefixProduct *= nums[i]
    }

    // println(answer.contentToString()) // 배열 출력

    var suffixProduct = 1
    for (i in nums.size - 1 downTo 0) {
      answer[i] *= suffixProduct
      suffixProduct *= nums[i]
    }

    return answer
  }
}