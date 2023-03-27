class Solution {
  public int[][] dir = {{0, 1}, {1, 0}};
  public int m, n;
  
  public int minPathSum(int[][] grid) {
    m = grid.length;
    n = grid[0].length;
    
    for (int y = 0; y < m; y++) {
      for (int x = 0; x < n; x++) {
        if (y == 0 && x == 0) continue;
        int left = isIn(y, x - 1) ? grid[y][x - 1] : Integer.MAX_VALUE;
        int top = isIn(y - 1, x) ? grid[y - 1][x] : Integer.MAX_VALUE;
        
        grid[y][x] += Math.min(left, top);
      }
    }
    
    return grid[m - 1][n - 1];
  }
  
  public boolean isIn(int y, int x) {
    if (0 <= y && y < m && 0 <= x && x < n) return true;
    return false;
  }
}