package leetcode;

/*
 Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

 If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

 You may not alter the values in the nodes, only nodes itself may be changed.

 Only constant memory is allowed.

 For example,
 Given this linked list: 1->2->3->4->5

 For k = 2, you should return: 2->1->4->3->5

 For k = 3, you should return: 3->2->1->4->5


 */
public class Q025_ReverseNodesInKGroups {
	
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode n = head;
		boolean valid = longerThanLength(n, k);
		ListNode fakeHead = new ListNode(0);
		ListNode pre = fakeHead;
		pre.next = head;
		while (valid) {
			reverse(pre, n, k);
			pre = n;
			n = n.next;
			
			valid = longerThanLength(n, k);
		}
		
		return fakeHead.next;
	}
	
	private boolean longerThanLength(ListNode head, int len) {
		ListNode n = head;
		int count = 0;
		ListNode fakeHead = new ListNode(0);
		fakeHead.next = head;
		n = fakeHead;
		while (n.next != null) {
			n = n.next;
			count++;
		}
		return count >= len;
	}
	
	private void reverse(ListNode last, ListNode head, int k) {
		ListNode n = head;
		
		ListNode next = null;
		ListNode pre = null;
		int count = 0;
		while (count < k) {
			next = n.next;
			n.next = pre;
			pre = n;
			n = next;
			count++;
		}
		last.next = pre;
		head.next = next;
	}
}
