class Solution {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int left = m - 1;
    int right = n - 1;
    int idx = nums1.length - 1;
    
    while (left >= 0 && right >= 0) {
      System.out.println("123");
      nums1[idx--] = nums1[left] < nums2[right] ? nums2[right--] : nums1[left--];
    }
    
    while (right >= 0) {
      nums1[idx--] = nums2[right--];
    }
  }
}