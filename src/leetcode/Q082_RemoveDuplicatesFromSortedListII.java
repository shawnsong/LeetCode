package leetcode;

/*
 Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only 
 distinct numbers from the original list.

 For example,
 Given 1->2->3->3->4->4->5, return 1->2->5.
 Given 1->1->1->2->3, return 2->3.
 */
public class Q082_RemoveDuplicatesFromSortedListII {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;
		
		ListNode fakeHead = new ListNode(0);
		ListNode pre = fakeHead;
		
		ListNode n1 = head;
		ListNode n2 = head.next;
		
		while (n2 != null) {
			if (n1 == n2) {
				while (n2 != null && n2 == n1)
					n2 = n2.next;
				n1 = n2;
				if (n2 != null)
					n2 = n2.next;
			} else {
				pre.next = n1;
				pre = n1;
				n1 = n2;
				n2 = n2.next;
			}
			
		}
		pre.next = n1;
		return fakeHead.next;
		
	}
}
