class Solution {
  public int firstCompleteIndex(int[] arr, int[][] mat) {
    int m = mat.length;
    int n = mat[0].length;
    boolean[][] v = new boolean[m][n];
    Map<Integer, int[]> map = new HashMap<>();

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        map.put(mat[i][j], new int[]{i, j});
      }
    }

    for (int i = 0; i < arr.length; i++) {
      int[] pos = map.get(arr[i]);
      v[pos[0]][pos[1]] = true;

      if (checkRow(v, pos) || checkCol(v, pos)) {
        return i;
      }
    }

    return -1;
  }

  private boolean checkRow(boolean[][] v, int[] pos) {
    for (int i = 0; i < v[0].length; i++) {
      if (!v[pos[0]][i]) {
        return false;
      }
    }

    return true;
  }

  private boolean checkCol(boolean[][] v, int[] pos) {
    for (int i = 0; i < v.length; i++) {
      if (!v[i][pos[1]]) {
        return false;
      }
    }

    return true;
  }
}