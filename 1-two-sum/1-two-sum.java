class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int first = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int second = nums[j];
                
                if (first + second == target) {
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }
        
        return answer;
    }
}