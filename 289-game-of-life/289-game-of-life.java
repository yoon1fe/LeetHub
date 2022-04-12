class Solution {
  public int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
  public int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};

  class Dir {
    int y;
    int x;

    public Dir(int y, int x) {
      this.y = y;
      this.x = x;
    }
  }
    
  public void gameOfLife(int[][] board) {
    int m = board.length;
    int n = board[0].length;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        Dir cur = new Dir(i, j);
        int liveNeighbor = 0;

        for (int k = 0; k < 8; k++) {
          Dir next = new Dir(cur.y + dy[k], cur.x + dx[k]);
          if (!isIn(next, m, n)) continue;

          if (board[next.y][next.x] == 1 || board[next.y][next.x] == 2) liveNeighbor++;
        }

        if (board[i][j] == 0 && liveNeighbor == 3) board[i][j] = 3;
        if (board[i][j] == 1 && (liveNeighbor < 2 || liveNeighbor > 3)) board[i][j] = 2;
      }
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        board[i][j]%= 2;
        System.out.print(board[i][j]);
      }
      System.out.println();
    }
  }

  private boolean isIn(Dir d, int m, int n) {
    return 0 <= d.y && d.y < m && 0 <= d.x && d.x < n;
  }
}