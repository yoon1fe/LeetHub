class Solution {
  public int numWaterBottles(int numBottles, int numExchange) {
    int answer = numBottles;
    int spare = numBottles;
    
    while (spare >= numExchange) {
      numBottles = spare / numExchange;
      spare -= (numBottles * numExchange);
      answer += numBottles;
      spare += numBottles;
    }
    
    return answer;
  }
}