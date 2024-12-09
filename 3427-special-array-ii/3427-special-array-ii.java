class Solution {
  public boolean[] isArraySpecial(int[] nums, int[][] queries) {
    boolean[] answer = new boolean[queries.length];
    int[] prefix = new int[nums.length];

    for (int i = 1; i < nums.length; i++) {
      prefix[i] = prefix[i - 1];
      if (nums[i] % 2 == nums[i - 1] % 2) {
        prefix[i]++;
      }
    }

    for (int i = 0; i < queries.length; i++) {
      int left = queries[i][0];
      int right = queries[i][1];

      int specialCount = prefix[right] - (left > 0 ? prefix[left] : 0);

      answer[i] = (specialCount == 0);
    }

    return answer;
  }
}