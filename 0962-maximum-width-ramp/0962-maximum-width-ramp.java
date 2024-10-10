class Solution {
  public int maxWidthRamp(int[] nums) {
    int answer = 0;
    Stack<Integer> stack = new Stack<>(); // monotonic decreasing stack

    for (int i = 0; i < nums.length; i++) {
      if (stack.isEmpty() || nums[stack.peek()] > nums[i]) {
        stack.push(i);
      }
    }

    for (int i = nums.length - 1; i >= 0; i--) {
      while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
        answer = Math.max(answer, i - stack.pop());
      }
    }


    return answer;
  }
}