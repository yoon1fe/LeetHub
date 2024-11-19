class Solution {
  public long maximumSubarraySum(int[] nums, int k) {
    Set<Integer> set = new HashSet<>();
    long answer = 0;
    long sum = 0;
    int j = 0;

    for (int i = 0; i < nums.length; i++) {
      // distinct 체크
      while (set.contains(nums[i])) {
        sum -= nums[j];
        set.remove(nums[j]);
        j++;
      }

      set.add(nums[i]);
      sum += nums[i];
      System.out.println("i = " + i + ", j = " + j);

      if (set.size() == k) {
        answer = Math.max(answer, sum);
        sum -= nums[j];
        set.remove(nums[j]);
        j++;
      }
    }

    return answer;
  }
}