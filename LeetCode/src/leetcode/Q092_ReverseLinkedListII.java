package leetcode;

/*
 Reverse a linked list from position m to n. Do it in-place and in one-pass.

 For example:
 Given 1->2->3->4->5->NULL, m = 2 and n = 4,

 return 1->4->3->2->5->NULL.

 Note:
 Given m, n satisfy the following condition:
 1 ¡Ü m ¡Ü n ¡Ü length of list. 
 */
public class Q092_ReverseLinkedListII {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null || head.next == null)
			return head;
		
		ListNode fakeHead = new ListNode(0);
		ListNode pre = fakeHead;
		pre.next = head;
		ListNode cur = head;
		int count= 1;
		while (count < m) {
			pre = cur;
			cur = cur.next;
			count++;
		}
		pre.next = null;
		ListNode partHead = cur;
		while (count < n) {
			cur = cur.next;
			count++;
		}
		ListNode next = cur.next;
		cur.next = null;
		
		ListNode newPartHead = reverse(partHead);
		pre.next = newPartHead;
		partHead.next = next;
		return fakeHead.next;
	}
	
	private ListNode reverse(ListNode head) {
		ListNode cur = head;
		ListNode pre = null;
		while (cur != null) {
			ListNode next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		
		return pre;
	}
}
