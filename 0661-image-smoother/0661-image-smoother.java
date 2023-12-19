class Solution {
  public int m, n;
  public int[] dy = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
  public int[] dx = {-1, 0, 1, -1, 0, 1, -1, 0, 1};

  public int[][] imageSmoother(int[][] img) {
    m = img.length;
    n = img[0].length;
    
    return makeAnswer(img);
  }
  
  private int[][] makeAnswer(int[][] img) {
    int[][] answer = new int[m][n];
    
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        answer[i][j] = calculateCell(img, i, j);
      }
    }
    
    return answer;
  }
  
  private int calculateCell(int[][] img, int y, int x) {
    int cnt = 0;
    int sum = 0;
    
    for (int i = 0; i < 9; i++) {
      int ny = y + dy[i];
      int nx = x + dx[i];
      if (isIn(ny, nx)) {
        cnt++;
        sum += img[ny][nx];
      }
    }
    
    return (int) Math.floor((double) sum / cnt);
  }
  
  private boolean isIn(int y, int x) {
    return 0 <= y && y < m && 0 <= x && x < n;
  }
}