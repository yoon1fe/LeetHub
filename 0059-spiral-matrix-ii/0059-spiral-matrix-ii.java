class Solution {
  int length;
  int[] dy = {0, 1, 0, -1};
  int[] dx = {1, 0, -1, 0};

  public int[][] generateMatrix(int n) {
    int[][] matrix = new int[n][n];
    length = n;
    int cy = 0;
    int cx = 0;
    int dir = 0;
    int dirCnt = 0;
    
    matrix[cy][cx] = 1;
    
    while (true) {
      int ny = cy + dy[dir];
      int nx = cx + dx[dir];
      
      if (canGo(ny, nx, matrix)) {
        dirCnt = 0;
        matrix[ny][nx] = matrix[cy][cx] + 1;
        
        cy = ny;
        cx = nx;
        
        continue;
      }
      
      dir = (dir + 1) % 4;
      dirCnt++;
      
      if (dirCnt == 3) {
        break;
      }
    }
    
    return matrix;
  }
  
  private boolean canGo(int y, int x, int[][] matrix) {
    if (!isIn(y, x)) return false;
    return matrix[y][x] == 0;
  }
  
  private boolean isIn(int y, int x) {
    if (0 <= y && y < length && 0 <= x && x < length) return true;
    return false;
  }
  
  
}