class Solution {
  public int minOperations(int[] nums, int k) {
    Set<Integer> set = new TreeSet<>();
    set.add(k);
    for (int n : nums) {
      set.add(n);
    }
    
    int min = Arrays.stream(nums).min().getAsInt();
    if (min < k) return -1;
    set.remove(Arrays.stream(nums).max().getAsInt());
    
    return set.size();
  }
}