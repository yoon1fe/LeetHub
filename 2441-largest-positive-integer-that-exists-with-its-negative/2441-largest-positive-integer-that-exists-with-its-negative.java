class Solution {
  public int findMaxK(int[] nums) {
    int left = 0;
    int right = nums.length - 1;
    Arrays.sort(nums);

    while (left < right) {
      if (Math.abs(nums[left]) == nums[right]) return Math.abs(nums[left]);
      if (Math.abs(nums[left]) < nums[right]) {
        right--;
      } else {
        left++;
      }
    }

    return -1;
  }
}