class Solution {
  private boolean[] v;
  int n;
  int max;
  int answer = 0;

  public int countMaxOrSubsets(int[] nums) {
    max = Arrays.stream(nums).reduce(0, (a, b) -> a | b);
    v = new boolean[nums.length];
    n = nums.length;

    subset(nums, 0, 0);

    return answer;
  }

  private void subset(int[] nums, int idx, int or) {
    if (idx == n) {
      if (or == max) {
        answer++;
      }
      return;
    }

    int newOr = or | nums[idx];
    subset(nums, idx + 1, newOr);
    subset(nums, idx + 1, or);
  }
}