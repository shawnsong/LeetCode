package leetcode;

/*
 Given a linked list, swap every two adjacent nodes and return its head.

 For example,
 Given 1->2->3->4, you should return the list as 2->1->4->3.

 Your algorithm should use only constant space. You may not modify the values in the 
 list, only nodes itself can be changed. 
 */
public class Q024_SwapNodesInPairs {

	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;
		
		ListNode fakeHead = new ListNode(0);

		ListNode prev = fakeHead;
		prev.next = head;
		while (prev.next != null && prev.next.next != null) {
			ListNode first = prev.next;
			ListNode second = prev.next.next;
			ListNode next = second.next;

			prev.next = second;
			second.next = first;
			first.next = next;
			prev = first;
		}
		return fakeHead.next;
	}
}
