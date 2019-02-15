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
		
		ListNode n = head;
		ListNode fakeHead = new ListNode(0);
		ListNode pre = fakeHead;
		ListNode next = null;
		
		while (n != null && n.next != null) {
			next = n.next.next;
			
			pre.next = n.next;
			n.next.next = n;
			n.next = next;
			
			pre = n;
			n = next;
		}
		
		return fakeHead.next;
	}
}
