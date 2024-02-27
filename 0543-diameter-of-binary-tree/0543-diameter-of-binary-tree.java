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
  private int diameter = 0;
  
  public int diameterOfBinaryTree(TreeNode root) {
    travel(root);
    return diameter;
  }
  
  private int travel(TreeNode root) {
    if (root == null) return 0;
    
    int left = travel(root.left);
    int right = travel(root.right);
    
    diameter = Math.max(diameter, left + right);
  
    return Math.max(left, right) + 1;
  }
}