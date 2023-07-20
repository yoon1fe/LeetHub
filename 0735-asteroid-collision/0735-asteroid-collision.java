class Solution {
  public int[] asteroidCollision(int[] asteroids) {
    Deque<Integer> deque = new ArrayDeque<>();
    
    for (int asteroid : asteroids) {
      collision(deque, asteroid);
    }
    
    return makeAnswer(deque);
  }
  
  private void collision(Deque<Integer> deque, int a) {
    if (deque.isEmpty()) {
      deque.addLast(a);
      return;
    }
    
    Integer top = deque.peekLast();
    
    if (top * a > 0 || (top < 0 && a > 0)) {
      deque.addLast(a);
      return;
    }
    
    while (top != null && (top > 0 && a < 0)) {
      deque.pollLast();
      if (Math.abs(top) == Math.abs(a)) return;
      
      a = selectBiggerSize(a, top);
      top = deque.peekLast();
    }
    
    deque.addLast(a);
  }
  
  private int[] makeAnswer(Deque<Integer> deque) {
    int[] answer = new int[deque.size()];
    
    int idx = 0;
    while (!deque.isEmpty()) {
      answer[idx++] = deque.pollFirst();
    }
    
    return answer;
  }
  
  private int selectBiggerSize(int a1, int a2) {
    return Math.abs(a1) < Math.abs(a2) ? a2 : a1;
  }
}