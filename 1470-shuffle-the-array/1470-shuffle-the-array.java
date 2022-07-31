class Solution {
  public int[] shuffle(int[] nums, int n) {
    int[] answer = new int[nums.length];
    int idx = 0;
    
    for (int i = 0; i < nums.length / 2; i++) {
      answer[idx++] = nums[i];
      answer[idx++] = nums[i + n];
    }
    
    return answer;
  }
}