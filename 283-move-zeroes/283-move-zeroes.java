class Solution {
    public void moveZeroes(int[] nums) {
        int[] answer = new int[nums.length];
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                answer[idx++] = nums[i];
            }
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                answer[idx++] = 0;
            }
        }
        
        for (int i = 0; i < nums.length; i++) {
            nums[i] = answer[i];
        }
        
    }
}