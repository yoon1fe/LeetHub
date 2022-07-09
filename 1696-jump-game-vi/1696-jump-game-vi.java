class Solution {
  public int maxResult(int[] nums, int k) {
    Deque<Integer> deque = new ArrayDeque<>();  // i - k 범위의 유효한 값중 가장 큰 값의 인덱스
    deque.add(0);

    for (int i = 1; i < nums.length; i++) {
      nums[i] += nums[deque.peekFirst()];


      // nums[i] 보다 작은 값의 인덱스는 제거
      while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
        deque.pollLast();
      }

      deque.offerLast(i);

      if (deque.peekFirst() <= i - k) {
        deque.pollFirst();
      }
    }

    return nums[nums.length - 1];
  }
}