class Solution {
  public String maximumOddBinaryNumber(String s) {
    int oneCount = -1;
    int size = s.length();
    boolean[] arry = new boolean[size];
    arry[size - 1] = true;

    for(int i = 0; i < size; i++) {
      if (s.charAt(i) - '0' == 1) oneCount++;
    }

    for (int i = 0; i < size; i++) {
      if (oneCount > 0) {
        arry[i] = true;
        oneCount--;
      }
    }

    return makeAnswer(arry);
  }

  private String makeAnswer(boolean[] arry) {
    StringBuilder answer = new StringBuilder();
    
    for (boolean b : arry) {
      answer.append(b ? "1" : "0");
    }

    return answer.toString();
  }
}