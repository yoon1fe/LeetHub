class Solution {
  private int[] dy = {1, -1, 0, 0};
  private int[] dx = {0, 0, 1, -1};
  private int m, n;
    
  public int[][] updateMatrix(int[][] mat) {
    m = mat.length;
    n = mat[0].length;
    int MAX_VALUE = m * n;
    Queue<int[]> q = new LinkedList<>();   
    
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (mat[i][j] == 0) {
          q.offer(new int[]{i, j});
        } else {
          mat[i][j] = MAX_VALUE;
        }
      }
    }
    
    while (!q.isEmpty()) {
      int[] cur = q.poll();
      
      for (int i = 0; i < 4; i++) {
        int ny = cur[0] + dy[i];
        int nx = cur[1] + dx[i];
        if (!isIn(ny, nx) || mat[ny][nx] <= mat[cur[0]][cur[1]] + 1) continue;
        
        q.offer(new int[]{ny, nx});
        mat[ny][nx] = mat[cur[0]][cur[1]] + 1;
      }
    }
    
    return mat;
  }
  
  private boolean isIn(int y, int x) {
    if (0 <= y && y < m && 0 <= x && x < n) return true;
    else return false;
  }
}