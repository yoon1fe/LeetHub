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
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    Stack<Integer> stk1 = listToStack(l1);
    Stack<Integer> stk2 = listToStack(l2);
    Deque<Integer> deque = new LinkedList<>();
    
    while (!stk1.isEmpty() || !stk2.isEmpty()) {
      int top1 = stk1.isEmpty() ? 0 : stk1.pop();
      int top2 = stk2.isEmpty() ? 0 : stk2.pop();
      
      if (deque.isEmpty()) {
        deque.addFirst(top1 + top2);
        continue;
      }
      
      if (deque.getFirst() >= 10) {
        int prev = deque.pollFirst();
        deque.addFirst(prev - 10);
        deque.addFirst(top1 + top2 + 1);
      } else {
        deque.addFirst(top1 + top2);
      }
    }
    
    if (deque.getFirst() >= 10) {
      deque.addFirst(deque.pollFirst() - 10);
      deque.addFirst(1);
    }
    
    return makeAnswer(deque);
  }
  
  private Stack<Integer> listToStack(ListNode l) {
    Stack<Integer> stk = new Stack<>();
    ListNode c = l;
    
    while (c != null) {
      stk.add(c.val);
      c = c.next;
    }
    
    return stk;
  }
  
  private ListNode makeAnswer(Deque<Integer> deque) {
    ListNode head = new ListNode(deque.pollFirst());
    ListNode cur = head;
    
    while (!deque.isEmpty()) {
      ListNode node = new ListNode(deque.pollFirst());
      cur.next = node;
      cur = node;
    }
    
    return head;
  }
}