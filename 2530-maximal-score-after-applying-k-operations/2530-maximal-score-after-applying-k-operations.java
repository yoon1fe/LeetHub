class Solution {
  public long maxKelements(int[] nums, int k) {
    long score = 0;
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

    for (int num : nums) {
      pq.offer(num);
    }
    
    for (int i = 0; i < k; i++) {
      int max = pq.poll();
      score += max;

      pq.offer((int) Math.ceil((double) max / 3));
    }

    // System.out.println(pq);
    return score;
  }

}