class MyStack {
  Queue<Integer> main;
  Queue<Integer> sub;
  
  public MyStack() {
    main = new LinkedList<>();
    sub = new LinkedList<>();
  }

  public void push(int x) {
    // 1) main -> sub
    while (!main.isEmpty()) {
      sub.add(main.poll());
    }
    
    // 2) main에 add
    main.add(x);
    
    // 3) sub -> main
    while (!sub.isEmpty()) {
      main.add(sub.poll());
    }
  }

  public int pop() {
    return main.poll();
  }

  public int top() {
    return main.peek();
  }

  public boolean empty() {
    return main.isEmpty();
  }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */