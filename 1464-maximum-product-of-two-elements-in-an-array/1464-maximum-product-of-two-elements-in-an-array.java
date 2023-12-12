class Solution {
  public int maxProduct(int[] nums) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    Arrays.stream(nums).forEach(num -> pq.offer(num));
    
    return (pq.poll() - 1) * (pq.poll() - 1);
  }
}