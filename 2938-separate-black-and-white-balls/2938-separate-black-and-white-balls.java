class Solution {
  public long minimumSteps(String s) {
    long answer = 0;
    int black = 0;

    for (char ch : s.toCharArray()) {
      if (ch == '1') {
        black++;
      } else if (ch == '0') {
        answer += black;
      }
    }

    return answer;
  }
}