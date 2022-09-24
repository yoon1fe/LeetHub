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
  public List<List<Integer>> answer = new ArrayList<>();

  public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    dfs(root, new ArrayList<Integer>(), targetSum, 0);
    
    return answer;
  }
    
  public void dfs(TreeNode node, List<Integer> list, int targetSum, int sum) {
    if (node == null) return;
    
    list.add(node.val);
    sum += node.val;
    
    if (node.left == null && node.right == null) {
      if (sum == targetSum) {
        answer.add(list);
      }
      return;
    }
    
    if (node.left != null) {
      dfs(node.left, new ArrayList<Integer>(list), targetSum, sum);
    }
    
    if (node.right != null) {
      dfs(node.right, new ArrayList<Integer>(list), targetSum, sum);
    }
  }
}