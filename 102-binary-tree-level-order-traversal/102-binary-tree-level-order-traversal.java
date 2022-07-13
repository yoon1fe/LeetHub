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
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> answer = new LinkedList<>();
    
    traverse(answer, root, 0);
    return answer;
  }
  
  public void traverse(List<List<Integer>> list, TreeNode node, int depth) {
    if (node == null) return;
    
    if (depth < list.size()) {
      list.get(depth).add(node.val);
    } else {
      List<Integer> temp = new LinkedList<>();
      temp.add(node.val);
      list.add(temp);
    }
    
    traverse(list, node.left, depth + 1);
    traverse(list, node.right, depth + 1);
  }
}