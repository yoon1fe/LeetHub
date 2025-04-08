class Solution {
  public int minimumOperations(int[] nums) {
    Queue<Integer> queue = new LinkedList<>();
    Map<Integer, Integer> map = new HashMap<>();
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      map.merge(num, 1, Integer::sum);
      set.add(num);
      queue.offer(num);
    }

    int answer = 0;
    
    while (set.size() != queue.size()) {
      answer++;
      int poll = queue.poll();
      int count = map.get(poll);
      if (count == 1) {
        map.remove(poll);
        set.remove(poll);
      } else {
        map.put(poll, count - 1);
      }
    }

    return answer / 3 + (answer % 3 == 0 ? 0 : 1);
  }
}