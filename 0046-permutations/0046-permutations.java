class Solution {
  List<Integer> indices = new LinkedList<>();
  List<List<Integer>> answer = new LinkedList<>();
  boolean[] v;
  
  public List<List<Integer>> permute(int[] nums) {
    v = new boolean[nums.length];
    
    permutation(0, nums);
    
    return answer;
  }
  
  private void permutation(int depth, int[] nums) {
    if (depth == nums.length) {
      answer.add(convert(indices, nums));
      return;
    }
    
    for (int i = 0; i < nums.length; i++) {
      if (v[i]) continue;
      v[i] = true;
      
      indices.add(i);
      permutation(depth + 1, nums);
      indices.remove((Integer) i);
      
      v[i] = false;
    }
  }
  
  private List<Integer> convert(List<Integer> indices, int[] nums) {
    return indices.stream().map(n -> nums[n]).collect(Collectors.toList());
  }
}