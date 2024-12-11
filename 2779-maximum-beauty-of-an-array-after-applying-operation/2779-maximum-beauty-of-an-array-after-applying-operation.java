class Solution {
  public int maximumBeauty(int[] nums, int k) {
    Arrays.sort(nums);
    int answer = 0;
    int left = 0;
    int right = 0;

    while (left < nums.length && right < nums.length)  {
      if (nums[right] - nums[left] <= 2 * k) {
        answer = Math.max(answer, right + 1 - left);
        right++;
      } else {
        left++;
      }
    }

    return answer;
  }
}