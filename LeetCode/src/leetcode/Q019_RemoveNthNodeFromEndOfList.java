package leetcode;

/*
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.

Note:
Given n will always be valid.
Try to do this in one pass. 
 */
public class Q019_RemoveNthNodeFromEndOfList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (n <= 0)
			return head;
		if (head == null)
			return null;
		
		int count = 0;
		
		ListNode fakeHead = new ListNode(0);
		fakeHead.next = head;
		ListNode fast = fakeHead;
		
		while(fast != null && count < n) {
			fast = fast.next;
			count++;
		}
		ListNode slow = fakeHead;
		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		
		slow.next = slow.next.next;
		return fakeHead.next;
	}
}
