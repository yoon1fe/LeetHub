class Solution {
  public int peakIndexInMountainArray(int[] arr) {
    int answer = 0;
    
    while (arr[answer] < arr[answer + 1]) {
      answer++;
    }
    
    return answer;
  }
}