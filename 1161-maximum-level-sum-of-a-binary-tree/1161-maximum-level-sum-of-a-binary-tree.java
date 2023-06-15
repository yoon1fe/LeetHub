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
  Map<Integer, List<Integer>> map = new HashMap<>();
  
  public int maxLevelSum(TreeNode root) {
    int answer = -1;
    int curMax = Integer.MIN_VALUE;
    dfs(1, root);
    
    for (int key : map.keySet()) {
      int sum = map.get(key).stream().mapToInt(Integer::intValue).sum();
      
      if (curMax < sum) {
        curMax = sum;
        answer = key;
      }
    }
    
    return answer;
  }
  
  private void dfs(int depth, TreeNode node) {
    if (node == null) return;
    
    List<Integer> list = map.getOrDefault(depth, new ArrayList<>());
    list.add(node.val);
    map.put(depth, list);
    
    dfs(depth + 1, node.left);
    dfs(depth + 1, node.right);
  }
}