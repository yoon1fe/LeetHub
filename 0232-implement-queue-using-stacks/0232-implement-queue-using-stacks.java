class MyQueue {
  Stack<Integer> push;
  Stack<Integer> pop;

  public MyQueue() {
    this.push = new Stack();
    this.pop = new Stack();
  }
    
  public void push(int x) {
    push.push(x);
  }

  public int pop() {
    // push -> pop
    while (!push.isEmpty()) {
      pop.push(push.pop());
    }

    int top = pop.pop();
    while (!pop.isEmpty()) {
      push.push(pop.pop());
    }
    return top;
  }
  
  public int peek() {
    while (!push.isEmpty()) {
      pop.push(push.pop());
    }

    int top = pop.pop();
    pop.push(top);
    while (!pop.isEmpty()) {
      push.push(pop.pop());
    }
    return top;
  }

  public boolean empty() {
    return push.isEmpty();
  }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */