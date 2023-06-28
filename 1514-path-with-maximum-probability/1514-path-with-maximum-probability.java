class Solution {
  private static class Node implements Comparable<Node> {
    private int to;
    private double prob;
    
    public Node(int to, double prob) {
      this.to = to;
      this.prob = prob;
    }
    
    public int compareTo(Node obj) {
      if (this.prob < obj.prob) return 1;
      else if (this.prob == obj.prob) return 0;
      else return -1;
    }
  }
  
  public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
    double answer = 0.0;
    PriorityQueue<Node> maxHeap = new PriorityQueue<>();
    Map<Integer, List<Node>> graph = makeGraph(edges, succProb);
    boolean[] v = new boolean[n];

    maxHeap.add(new Node(start, 1.0));
    
    while (!maxHeap.isEmpty()) {
      Node cur = maxHeap.poll();
      v[cur.to] = true;
      
      if (cur.to == end) {
        answer = cur.prob;
        break;
      }

      if (!graph.containsKey(cur.to)) continue;
      
      for (Node next : graph.get(cur.to)) {
        if (v[next.to]) continue;
        maxHeap.add(new Node(next.to, next.prob * cur.prob));        
      } 
    }
    
    return answer;
  }
  
  private Map<Integer, List<Node>> makeGraph(int[][] edges, double[] prob) {
    Map<Integer, List<Node>> graph = new HashMap<>();
    
    for (int i = 0; i < edges.length; i++) {
      int[] edge = edges[i];
      
      insertNode(graph, edge[0], edge[1], prob[i]);
      insertNode(graph, edge[1], edge[0], prob[i]);
    }
    
    return graph;
  }
                
  private void insertNode(Map<Integer, List<Node>> graph, int from, int to, double prob) {
    List<Node> temp = graph.getOrDefault(from, new ArrayList<>());
    temp.add(new Node(to, prob));
    graph.put(from, temp);
  }
}