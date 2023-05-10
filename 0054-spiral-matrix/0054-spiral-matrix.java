class Solution {
  public int[] dy = {0, 1, 0, -1};
  public int[] dx = {1, 0, -1, 0};
  public boolean[][] visited;
  public int dir = 0;
  public int m, n;
  
  class Point {
    int y;
    int x;
    
    Point(int y, int x) {
      this.y = y;
      this.x = x;
    }
    
    Point next(int i) {
      return new Point(this.y + dy[i], this.x + dx[i]);
    }
  }
  
  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> list = new ArrayList<>();
    m = matrix.length;
    n = matrix[0].length;
    visited = new boolean[m][n];
    
    Point cur = new Point(0, 0);
    visit(list, matrix, cur);    
    
    while (list.size() < m * n) {
      Point next = cur.next(dir);
      
      if (isIn(next, m, n) && !visited[next.y][next.x]) {
        cur = next;
        visit(list, matrix, cur);
      } else {
        dir = (dir + 1) % 4;
      }
    }
        
    return list;
  }
  
  private void visit(List<Integer> list, int[][] matrix, Point p) {
    list.add(matrix[p.y][p.x]);
    visited[p.y][p.x] = true;
  }
  
  private boolean isIn(Point p, int m, int n) {
    return 0 <= p.y && p.y < m && 0 <= p.x && p.x < n;
  }
}