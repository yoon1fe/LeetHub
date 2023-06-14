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
  List<Integer> list = new ArrayList<>();
  public int minDiffInBST(TreeNode root) {
    int answer = Integer.MAX_VALUE;
    traverse(root);
    
    Collections.sort(list);
    
    for (int i = 0; i < list.size() - 1; i++) {
      int diff = list.get(i + 1) - list.get(i);
      answer = answer < diff ? answer : diff;      
    }
    
    return answer;
  }
  
  private void traverse(TreeNode node) {
    if (node == null) return;
    
    list.add(node.val);
    traverse(node.left);
    traverse(node.right);
  }
}