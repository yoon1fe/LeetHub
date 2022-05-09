class Solution {
  public boolean backspaceCompare(String s, String t) {
    return getString(s).equals(getString(t));
  }
  
  private String getString(String s) {
    Stack<Character> stack = new Stack<>();
    
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      
      if (ch == '#') {
        if (stack.isEmpty()) continue;
        stack.pop();
      } else {
        stack.push(ch);
      }
    }
    
    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append(stack.pop());
    }
    
    return sb.reverse().toString();
  }
}