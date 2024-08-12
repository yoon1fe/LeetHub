class KthLargest {
  private PriorityQueue<Integer> minHeap;
  int k;

  public KthLargest(int k, int[] nums) {
    minHeap = new PriorityQueue<>();
    this.k = k;
    for (int num : nums) {
      if (minHeap.size() < k) minHeap.add(num);
      else addToMinHeap(num);
    }
  }
  
  public int add(int val) {
    addToMinHeap(val);
    return minHeap.peek();
  }
  
  private void addToMinHeap(int num) {
    if (minHeap.isEmpty() || minHeap.size() < k) {
      minHeap.add(num);
      return;
    }
    if (minHeap.peek() >= num) return;
    minHeap.poll();
    minHeap.add(num);
  }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */