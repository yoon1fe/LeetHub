class Solution {
    public int searchInsert(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }
    
    private int binarySearch(int[] nums, int target, int left, int right) {
        if (left > right) return left;
        
        int mid = (left + right) / 2;
        
        if (target == nums[mid]) return mid;
        if (nums[mid] < target) {
            return binarySearch(nums, target, mid + 1, right);
        }
        else return binarySearch(nums, target, left, mid - 1);
    }
}