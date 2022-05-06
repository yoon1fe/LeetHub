class Solution {
  class Element {
    char ch;
    int n;
    
    Element(char ch, int n) {
      this.ch = ch;
      this.n = n;
    }
    
    // public String toString() {
    //   return "[" + ch + ", " + n + "]";
    // }
  }
  
  public String removeDuplicates(String s, int k) {
    Stack<Element> stack = new Stack<>();
    
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      
      if (stack.isEmpty()) {
        stack.push(new Element(ch, 1));
        continue;
      }
      
      Element top = stack.peek();
      if (ch == top.ch) {
        stack.pop();
        if (k != top.n + 1) {
          stack.push(new Element(ch, top.n + 1));
        }
        
        continue;
      } 
        
      stack.push(new Element(ch, 1));
    }
    
    return getAnswer(stack);
  }
  
  private String getAnswer(Stack<Element> stack) {
    StringBuilder sb = new StringBuilder();
    
    while (!stack.isEmpty()) {
      Element top = stack.pop();
      for (int i = 0; i < top.n; i++) {
        sb.append(top.ch);
      }
    }
    
    return sb.reverse().toString();
  }
}