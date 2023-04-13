class Solution {
  public boolean validateStackSequences(int[] pushed, int[] popped) {
    Stack<Integer> stack = new Stack<>();
    int pu = 0;
    int po = 0;
    
    stack.push(pushed[pu++]);
    
    while (!stack.isEmpty()) {
      
      while (stack.peek() != popped[po]) {
        if (pu == pushed.length) return false;
        stack.push(pushed[pu++]);
      }
      
      stack.pop();
      po++;
      
      if (stack.isEmpty() && pu < pushed.length) {
        stack.push(pushed[pu++]);
      }
    }
    
    return true;
  }
}