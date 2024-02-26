class Solution {
  public int furthestBuilding(int[] heights, int bricks, int ladders) {
    // 빌딩 높이 차이를 저장
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    
    for (int i = 0; i < heights.length - 1; i++) {
      int diff = heights[i + 1] - heights[i];
      if (diff <= 0) {
        continue;
      }
      
      pq.offer(diff);
      if (pq.size() > ladders) {
        bricks -= pq.poll();
      }
      
      if (bricks < 0) {
        return i;
      }
    }
    
    return heights.length - 1;
  }
}