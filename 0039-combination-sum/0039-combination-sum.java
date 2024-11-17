class Solution {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(candidates);

    backTracking(list, candidates, target, 0, new ArrayList<>());

    return list;
  }

  private void backTracking(List<List<Integer>> list, int[] nums, int remain, int start, List<Integer> temp) {
    if (remain < 0) return;
    if (remain == 0) list.add(new ArrayList<>(temp));

    for (int i = start; i < nums.length; i++) {
      temp.add(nums[i]);
      backTracking(list, nums, remain - nums[i], i, temp);
      temp.remove(temp.size() - 1);
    }
  }
}