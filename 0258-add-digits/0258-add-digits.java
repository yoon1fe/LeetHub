class Solution {
  public int addDigits(int num) {
    return makeAnswer(num);
  }
  
  
  private int makeAnswer(int num) {
    if (num < 10) return num;
    int sum = 0;
    int tempNum = num;
    
    while (tempNum != 0) {
      sum += tempNum % 10;
      tempNum = tempNum / 10;
    }
    
    return makeAnswer(sum);
  }
}