class Solution {
  public int eraseOverlapIntervals(int[][] intervals) {
    int answer = 0;
    int last = -50001;
    Arrays.sort(intervals, (int[] a1, int[] a2) -> {
      if (a1[1] == a2[1]) return a2[0] - a1[0];
      return a1[1] - a2[1];
    });
    
    for (int[] interval : intervals) {      
      if (last > interval[0]) answer++;
      else last = interval[1];  
    }
    
    return answer;
  }
}