class Solution {
    public long zeroFilledSubarray(int[] nums) {
      return searchZeros(nums);
    }

    public long searchZeros(int[] nums) {
      long answer = 0;
      long consecutive = 0;
      for (int num : nums) {
        if (num == 0) {
          consecutive++;
          answer += consecutive;
        } else {
          consecutive = 0;
        }
      }

      return answer;
    }
}