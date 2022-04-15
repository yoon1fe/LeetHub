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
  public TreeNode searchBST(TreeNode root, int val) {
    
    TreeNode cur = root;
    
    while (cur != null) {
      if (cur.val == val) {
        return cur;
      } else if (cur.val > val) {
        cur = cur.left;
      } else {
        cur = cur.right;
      }
    }

    return null;
  }
}