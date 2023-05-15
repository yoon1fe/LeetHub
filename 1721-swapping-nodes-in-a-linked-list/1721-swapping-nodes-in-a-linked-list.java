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
  public ListNode swapNodes(ListNode head, int k) {
    
    int[] array = listToArray(head);
    
    System.out.println(Arrays.toString(array));
    swap(array, k);
    System.out.println(Arrays.toString(array));
    
    return listToLinkedList(array);
  }
  
  private int[] listToArray(ListNode head) {
    List<Integer> list = new ArrayList<>();
    ListNode node = head;
    
    while (node != null) {
      list.add(node.val);
      node = node.next;
    }
    
    return list.stream().mapToInt(i -> i).toArray();
  }
  
  private void swap(int[] array, int k) {
    int front = k - 1;
    int rear = array.length - k;
    int temp = array[front];
    array[front] = array[rear];
    array[rear] = temp;
  }
  
  private ListNode listToLinkedList(int[] list) {
    ListNode head = new ListNode();
    ListNode next = head;
    
    for (int n : list) {
      ListNode cur = new ListNode(n);
      next.next = cur;
      next = cur;
    }
    
    return head.next;
  }
  
}