class Solution {
  public int[] sortArrayByParity(int[] nums) {
    int left = 0;
    int right = nums.length - 1;
    
    while (left < right) {
      if (nums[left] % 2 == 0) {
        left++;
        continue;
      }
      if (nums[right] % 2 == 0) {
        swap(nums, left, right);
      }
      
      right--;
    }
    
    return nums;
  }
  
  public void swap(int[] nums, int left, int right) {
    int temp = nums[left];
    nums[left] = nums[right];
    nums[right] = temp;
  }
}