class Solution {
  public boolean check(int[] nums) {
    nums = distinct(nums);
    int minIndex = 0;
    int min = 101;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] <= min) {
        minIndex = i;
        min = nums[i];
      }
    }
    
    for (int i = minIndex; i < minIndex + nums.length - 1; i++) {
      int cur = nums[i % nums.length];
      int next = nums[(i + 1) % nums.length];
      
      System.out.println("i = " + i + ", c = " + cur + ", n = " + next);
      if (cur > next) return false;
    }

    return true;
  }

  private int[] distinct(int[] nums) {        
    List<Integer> list = new ArrayList<>();
    list.add(nums[0]);

    for (int i = 1; i < nums.length; i++) {
        if (nums[i] != (nums[i - 1])) {
            list.add(nums[i]);
        }
    }

    int[] ret = new int[list.size()];
    int i = 0;
    for (int n : list) {
      ret[i++] = n;
    }

    return ret;
  }
}