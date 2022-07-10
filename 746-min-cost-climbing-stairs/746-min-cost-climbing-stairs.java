class Solution {
  public int minCostClimbingStairs(int[] cost) {
    int n = cost.length;
    int[] dp = Arrays.copyOf(cost, n + 1);
    
    for (int i = 2; i < dp.length; i++) {
      dp[i] += Math.min(dp[i - 2], dp[i - 1]);
    }
    
    return dp[n];
  }
}