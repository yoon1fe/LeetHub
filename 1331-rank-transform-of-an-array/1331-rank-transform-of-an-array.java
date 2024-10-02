class Solution {
  public int[] arrayRankTransform(int[] arr) {
    int[] answer = new int[arr.length];
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    Map<Integer, Integer> map = new HashMap<>();
    int rank = 1;
    int prev = -1;
    for (int n : arr) {
      pq.offer(n);
    }

    while (!pq.isEmpty()) {
      int cur = pq.poll();
      if (prev == cur) {
        map.put(cur, map.get(cur));
        continue;
      }
      
      map.put(cur, rank++);
      prev = cur;
    }

    for (int i = 0; i < arr.length; i++) {
      answer[i] = map.get(arr[i]);
    }

    return answer;
  }
}