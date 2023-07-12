class Solution {
  private Map<Integer, Boolean> map = new HashMap<>();
  private int[] v;

  public List<Integer> eventualSafeNodes(int[][] graph) {
    List<Integer> answer = new ArrayList<>();
    int n = graph.length;
    v = new int[n];
    
    for (int i = 0; i < n; i++) {
      if (dfs(graph, i)) answer.add(i);
    }
    
    return answer;
  }
  
  
  private boolean dfs(int[][] graph, int cur) {
    if (v[cur] == 1) return false;
    v[cur] = 1;

    for (int next : graph[cur]) {
      int status = v[next];
      if (status == 1) return false;
      if (status == 2) continue;
      
      if (!dfs(graph, next)) return false;
    }
    
    v[cur] = 2;
    return true;
  }
}