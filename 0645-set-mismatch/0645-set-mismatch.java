class Solution {
  public int[] findErrorNums(int[] nums) {
    int[] answer = new int[2];
    Map<Integer, Integer> map = Arrays.stream(nums)
      .boxed()
      .collect(Collectors.toMap(
        key -> key,
        value -> 1,
        (v1, v2) -> v1 + v2,
        HashMap::new
      ));
    
    for (int i = 1; i <= nums.length; i++) {
      if (!map.containsKey(i)) {
        answer[1] = i;
        continue;
      }
      
      if (map.get(i) > 1) {
        answer[0] = i;
        continue;
      }
      
    }
    
    return answer;
  }
}