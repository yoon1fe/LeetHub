/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
  int max = -1;
  public int maxDepth(TreeNode root) {
    travel(root, 0);
    return max;
  }
  
  private void travel(TreeNode node, int depth) {
    max = Math.max(max, depth);
    if (node != null) {
      travel(node.left, depth + 1);
      travel(node.right, depth + 1);
    }
  }
}