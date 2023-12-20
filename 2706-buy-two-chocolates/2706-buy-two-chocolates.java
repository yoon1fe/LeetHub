class Solution {
  public int buyChoco(int[] prices, int money) {
    int answer = -1;
    Arrays.sort(prices);
    
    for (int i = 0; i < prices.length - 1; i++) {
      for (int j = i + 1; j < prices.length; j++) {
        int leftover = money - (prices[i] + prices[j]);
        if (leftover < 0) continue;
        
        answer = Math.max(answer, leftover);
      }
    }
    return answer == -1 ? money : answer;
  }
}