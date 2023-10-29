class Solution {
  public int maximumCount(int[] nums) {
    int pos = 0;
    int neg = 0;
    
    for (int num : nums) {
      if (num > 0) pos++;
      if (num < 0) neg++;
    }
    
    return Math.max(pos, neg);
  }
}