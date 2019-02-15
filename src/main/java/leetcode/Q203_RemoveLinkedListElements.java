package leetcode;

/*
Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5 
 */
public class Q203_RemoveLinkedListElements {
	public ListNode removeElements(ListNode head, int val) {
		if (head == null)
			return null;
		
		ListNode fakeHead = new ListNode(0);
		fakeHead.next = head;
		
		ListNode pre = fakeHead;
		ListNode cur = head;
		
		while (cur != null) {
			if (cur.val == val) {
				cur = cur.next;
			} else {
				pre.next = cur;
				pre = cur;
				cur = cur.next;
			}
		}
		
		pre.next = null;
		return fakeHead.next;
	}
}
