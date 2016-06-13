package leetcode;

/*
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
 */
public class Q061_RotateList {
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null)
			return head;

		int len = getLength(head);
		if (k % len == 0)
			return head;
		k = k % len;
		int x = len - k;

		int count = 0;
		ListNode n = head;

		ListNode pre = null;
		while (count < x) {
			pre = n;
			n = n.next;
			count++;
		}
		pre.next = null;
		ListNode newHead = n;
		while (n.next != null)
			n = n.next;
		n.next = head;
		return newHead;
	}

	private int getLength(ListNode head) {
		int count = 0;
		while (head != null) {
			count++;
			head = head.next;
		}
		return count;
	}
}
