class Solution {
  public int[] dy = {0, 1, 0, -1};
  public int[] dx = {1, 0, -1, 0};
  public int dir = 0;
  
  public int[][] generateMatrix(int n) {
    int[][] answer = new int[n][n];
    int cy = 0;
    int cx = 0;
    int start = 1;
    
    answer[cy][cx] = start++;
    
    while (start <= n * n) {
      int ny = cy + dy[dir];
      int nx = cx + dx[dir];
      
      if (isIn(ny, nx, n) && answer[ny][nx] == 0) {
        answer[ny][nx] = start++;
        cy = ny;
        cx = nx;
      } else {
        dir = (dir + 1) % 4;
      }
      
    }
    
    return answer;
  }
  
  public boolean isIn(int y, int x, int n) {
    return 0 <= y && y < n && 0 <= x && x < n;
  }
}