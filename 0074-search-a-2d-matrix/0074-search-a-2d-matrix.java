class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
    int[] array = convertTo1DArray(matrix);
    
    return binarySearch(array, 0, array.length - 1, target);
  }
  
  private int[] convertTo1DArray(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    int[] result = new int[m * n];
    int idx = 0;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        result[idx++] = matrix[i][j];
      }
    }
    
    return result;
  }
  
  private boolean binarySearch(int[] array, int left, int right, int target) {
    if (left > right) return false;
    
    int mid = (left + right) / 2;
    if (array[mid] == target) return true;
    if (array[mid] > target) return binarySearch(array, left, mid - 1, target);
    return binarySearch(array, mid + 1, right, target);
  }
}