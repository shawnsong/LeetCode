package leetcode;

//Sort a linked list using insertion sort.
public class Q147_InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		
		ListNode fakeHead = new ListNode(0);
		ListNode pre = fakeHead, cur = head;
		
		while(cur != null) {
			ListNode next = cur.next;
			if (fakeHead.next == null) {
				fakeHead.next = cur;
				cur.next = null;
				cur = next;
				continue;
			}
			ListNode n = fakeHead.next;
			pre = fakeHead;
			while (n != null && cur.val > n.val) {
				pre = n;
				n = n.next;
			}
			pre.next = cur;
			cur.next = n;
			cur = next;
		}
		
		return fakeHead.next;
	}
}
