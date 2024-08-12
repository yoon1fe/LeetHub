class KthLargest {
  private PriorityQueue<Integer> minHeap;
  int k;

  public KthLargest(int k, int[] nums) {
    minHeap = new PriorityQueue<>();
    this.k = k;
    for (int num : nums) {
      add(num);
    }
  }
  
  public int add(int val) {
    if (minHeap.isEmpty() || minHeap.size() < k) {
      minHeap.add(val);
    } else {
      if (minHeap.peek() < val) {
        minHeap.poll();
        minHeap.add(val);
      }
    }

    return minHeap.peek();
  }
}