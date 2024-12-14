class Solution {
  public long continuousSubarrays(int[] nums) {
    long answer = 0;
    int j = 0;
    Map<Integer, Integer> map = new HashMap<>();
    
    for (int i = 0; i < nums.length; i++) {
      map.merge(nums[i], 1, Integer::sum);

      while ((i - j + 1) > getCount(nums[i], map)) {
        map.put(nums[j], map.get(nums[j]) - 1);
        j++;
      }
      answer += (i - j + 1);
    }
    return answer;
  }

  private int getCount(int num, Map<Integer, Integer> map) {
    return map.getOrDefault(num, 0) + map.getOrDefault(num - 1, 0) + 
      map.getOrDefault(num + 1, 0) + map.getOrDefault(num - 2, 0) + map.getOrDefault(num + 2, 0);
  }

}