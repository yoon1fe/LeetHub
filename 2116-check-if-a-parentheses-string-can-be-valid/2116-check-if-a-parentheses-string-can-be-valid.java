class Solution {
  public boolean canBeValid(String s, String l) {
    int n = s.length();
    if (n % 2 == 1) return false;
    Stack<Integer> open = new Stack<>();
    Stack<Integer> unlocked = new Stack<>();

    for (int i = 0; i < n; i++) {
      if (l.charAt(i) == '0') {
        unlocked.push(i);
      } else if (s.charAt(i) == '(') {
        open.push(i);
      } else if (s.charAt(i) == ')') {
        if (!open.isEmpty()) {
          open.pop();
        } else {
          if (!unlocked.isEmpty()) {
            unlocked.pop();
          } else {
            return false;
          }
        }
      }
    }

    while (!open.isEmpty() && !unlocked.isEmpty() && open.peek() < unlocked.peek()) {
      open.pop();
      unlocked.pop();
    }
    
    return open.isEmpty();
  }

}