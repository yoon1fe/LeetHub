/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
  public ListNode partition(ListNode head, int x) {
    ListNode leftHead = new ListNode();
    ListNode rightHead = new ListNode();
    ListNode left = leftHead;
    ListNode right = rightHead;
    ListNode node = head;
    while (node != null) {
      if (node.val < x) {
        left.next = node;
        left = left.next;
      } else {
        right.next = node;
        right = right.next;
      }
      
      node = node.next;
    }
    
    right.next = null;
    left.next = rightHead.next;
      
    return leftHead.next;
  }
}