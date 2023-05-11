class Solution {
  
  public int diagonalSum(int[][] mat) {
    int n = mat.length;
    boolean[][] visited = new boolean[n][n];
    int answer = 0;
    
    int cy = 0;
    int cx = 0;
    
    for (int i = 0; i < n; i++) {      
      visited[cy][cx] = true;
      answer += mat[cy][cx];
      cy++;
      cx++;
    }
        
    cy = 0;
    cx = n - 1;
    
    for (int i = 0; i < n; i++) {
      if (visited[cy][cx]) {
        cy++;
        cx--;
        continue;
      }
      
      visited[cy][cx] = true;
      answer += mat[cy][cx];
      cy++;
      cx--;
    }
    
    return answer;
  }
}