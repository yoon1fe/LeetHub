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
  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> answer = new LinkedList<>();
    
    seeRight(root, answer, 0);
    return answer;
  }
  
  public void seeRight(TreeNode node, List<Integer> list, int depth) {
    if (node == null) return;
    if (depth == list.size()) {
      list.add(node.val);
    }
    seeRight(node.right, list, depth + 1);
    seeRight(node.left, list, depth + 1);
  }
}