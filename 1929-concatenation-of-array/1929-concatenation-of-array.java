class Solution {
  public int[] getConcatenation(int[] nums) {
    int length = nums.length;
    int[] concate = new int[length + length];
    System.arraycopy(nums, 0, concate, 0, length);  
    System.arraycopy(nums, 0, concate, length, length);  
    return concate;
  }
}