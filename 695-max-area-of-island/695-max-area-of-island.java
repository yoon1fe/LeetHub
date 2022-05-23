class Solution {
  class Dir {
    int y;
    int x;
    
    public Dir(int y, int x) {
      this.y = y;
      this.x = x;
    }
  }
  
  public int[] dy = {1, -1, 0, 0};
  public int[] dx = {0, 0, 1, -1};
  public int m;
  public int n;

  public int maxAreaOfIsland(int[][] grid) {
    int answer = 0;
    m = grid.length;
    n = grid[0].length;
    
    boolean[][] v = new boolean[m][n];
    
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 0 || v[i][j]) continue;
        answer = Math.max(bfs(i, j, grid, v), answer);
      }
    }
    
    return answer;
  }
  
  public int bfs(int y, int x, int[][] grid, boolean[][] v) {
    int area = 1;
    Queue<Dir> q = new LinkedList<>();
    q.offer(new Dir(y, x));
    v[y][x] = true;
    
    while (!q.isEmpty()) {
      Dir cur = q.poll();
      
      for (int i = 0; i < 4; i++) {
        Dir next = new Dir(cur.y + dy[i], cur.x + dx[i]);
        if (isIn(next) && grid[next.y][next.x] == 1 && !v[next.y][next.x]) {
          v[next.y][next.x] = true;
          q.offer(next);
          area++;
        }
      }
    }
    
    return area;
  }
  
  public boolean isIn(Dir d) {
    return 0 <= d.y && d.y < m && 0 <= d.x && d.x < n;
  }
}