package leetcode;

/* Reverse a singly linked list.
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class Q206_ReverseLinkedList {

	// iterative
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		
		ListNode prev= null;
		ListNode cur = head;
		ListNode next = null;
		
		while (cur != null) {
			next = cur.next;
			cur.next = prev;
			
			prev = cur;
			cur = next;
		}
		return prev;
	}
	
	// recursive
	public ListNode reverseList1(ListNode head) {
		if (head == null)
			return null;
		ListNode newHead = reverseList1(head.next);
		if (newHead == null) {
			return head;
		}
		
		ListNode n = newHead;
		while (n.next != null) {
			n = n.next;
		}
		n.next = head;
		head.next = null;
		return newHead;
	}
}
