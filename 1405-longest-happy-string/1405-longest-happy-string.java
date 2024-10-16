class Solution {
  public static class Node {
    int n;
    char ch;

    public Node(int n, char ch) {
      this.n = n;
      this.ch = ch;
    }
    public String toString() {
      return "n : " + n + ", ch : " + ch;
    }
  }

  public String longestDiverseString(int a, int b, int c) {
    StringBuilder sb = new StringBuilder();
    PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o2.n - o1.n);  // {idx, num}
    if (a > 0) pq.offer(new Node(a, 'a'));
    if (b > 0) pq.offer(new Node(b, 'b'));
    if (c > 0) pq.offer(new Node(c, 'c'));
    
    int consecutive = 0;
    char lastChar = pq.peek().ch;
    
    // System.out.println(pq);
    while (!pq.isEmpty()) {
      Node cur = pq.poll();
      if (cur.n == 0) continue;
      if (consecutive == 2) {
        if (!pq.isEmpty()) {
          Node next = pq.poll();
          sb.append(next.ch);
          consecutive = 1;
          lastChar = next.ch;
          if (next.n > 1) {
            pq.offer(new Node(next.n - 1, next.ch));
          }
          pq.offer(cur);
          continue;
        } else {
          return sb.toString();
        }
      }
      
      if (cur.ch == lastChar) {
        consecutive++;
      } else {
        lastChar = cur.ch;
      }
      sb.append(cur.ch);
      if (cur.n > 1) {
        pq.offer(new Node(cur.n - 1, cur.ch));
      }
    }
    return sb.toString();
  }
  
}