class Solution {
  public int lengthOfLIS(int[] nums) {
    int[] dp = new int[nums.length];
    int LIS = 0;
    
    Arrays.fill(dp, -10001);
    
		for (int i = 0; i < dp.length; i++) {
			int idx = binarySearch(nums[i], 0, LIS, LIS + 1, dp);

			if(idx == -1) {
				dp[LIS++] = nums[i];
			} else {
				dp[idx] = nums[i];
			}
		}
    
    return LIS;
  }
  
  private int binarySearch(int num, int start, int end, int size, int[] dp) {
		int res = 0;

		while (start <= end) {
			int mid = (start + end) / 2;

			if (num <= dp[mid]) {
				res = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		if (start == size) {
			return -1;
		} else {
			return res;
		}
	}
}