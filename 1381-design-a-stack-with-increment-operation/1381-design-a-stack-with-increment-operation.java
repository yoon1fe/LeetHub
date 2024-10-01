class CustomStack {
  private List<Integer> stack;
  private int top;
  private int size;

  public CustomStack(int maxSize) {
    stack = new ArrayList<>(maxSize);
    top = -1;
    size = maxSize;
  }
  
  public void push(int x) {
    if (top + 1 == size) {
      return;
    }

    stack.add(x);
    top++;
  }
  
  public int pop() {
    if (stack.isEmpty()) {
      return -1;
    }
    
    int topElement = stack.get(top);
    stack.remove(top--);
    return topElement;
  }
  
  public void increment(int k, int val) {
    for (int i = 0; i < Math.min(k, top + 1); i++) {
      stack.set(i, stack.get(i) + val);
    }
  }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */