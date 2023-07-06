class Solution {
  public int minSubArrayLen(int target, int[] nums) {
    int answer = Integer.MAX_VALUE;
    int left = 0;
    int sum = 0;
    
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      
      while (sum >= target) {
        answer = Math.min(answer, i + 1 - left);
        sum -= nums[left];
        left++;
      }
    }
    
    return answer != Integer.MAX_VALUE ? answer : 0;
  }
}