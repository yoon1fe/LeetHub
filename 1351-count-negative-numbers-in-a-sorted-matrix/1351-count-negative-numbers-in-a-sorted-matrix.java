class Solution {
  public int countNegatives(int[][] grid) {
    int answer = 0;
    
    for (int[] row : grid) {
      // binary search
      
      int left = 0;
      int right = row.length - 1;
      
      while (left <= right) {
        int mid = (left + right) / 2;
        if (row[mid] < 0) right = mid - 1;
        else left = mid + 1;
      }
      
      answer += (row.length - left);
    }
    
    return answer;
  }
}