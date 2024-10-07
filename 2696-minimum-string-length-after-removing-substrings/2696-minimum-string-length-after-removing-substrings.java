class Solution {
  public int minLength(String s) {
    int answer = 0;
    Stack<Character> stack = new Stack<>();
    
    for (char ch : s.toCharArray()) {
      if (stack.isEmpty()) {
        stack.push(ch);
      } else {
        char top = stack.peek();
        if (top == 'A' && ch == 'B') {
          stack.pop();
          continue;
        }

        if (top == 'C' && ch == 'D') {
          stack.pop();
          continue;
        }

        stack.push(ch);
      }
    }

    return stack.size();
  }
}