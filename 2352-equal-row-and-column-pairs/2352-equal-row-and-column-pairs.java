class Solution {
  public int equalPairs(int[][] grid) {
    int answer = 0;
    int[][] diagonal = makeDiagonalGrid(grid);
    
    for (int i = 0; i < grid.length; i++) {
      int[] row = grid[i];
      
      for (int j = 0; j < grid[i].length; j++) {
        if (Arrays.equals(row, diagonal[j])) {
          answer++;
        }        
      }
    }
    
    return answer;
  }
  
  private int[][] makeDiagonalGrid(int[][] grid) {
    int[][] diagonal = new int[grid.length][grid.length];
    
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid.length; j++) {
        diagonal[i][j] = grid[j][i];
      }
    }
    
    return diagonal;
  }
}