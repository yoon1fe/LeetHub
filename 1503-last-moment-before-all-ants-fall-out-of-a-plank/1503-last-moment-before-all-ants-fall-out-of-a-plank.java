class Solution {
  public int getLastMoment(int n, int[] left, int[] right) {
    int answer = 0;
    
    for (int i = 0; i < left.length; i++) {
      answer = Math.max(answer, left[i]);
    }
    for (int i = 0; i < right.length; i++) {
      answer = Math.max(answer, n - right[i]);
    }
    
    return answer;
  }
}