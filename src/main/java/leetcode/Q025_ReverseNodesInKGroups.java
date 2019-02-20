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
		if (head == null || k <= 0) {
			return head;
		}

		boolean valid = longerThanRest(head, k);

		ListNode fakeHead = new ListNode(0);
		fakeHead.next = head;
		ListNode pre = fakeHead;
		ListNode cur = head;
		while (valid) {
			reverseInRange(pre, cur, k);
			pre = cur;
			cur = cur.next;
			valid = longerThanRest(cur, k);
		}
		return fakeHead.next;
	}

	private boolean longerThanRest(ListNode head, int len) {
		int count = 0;
		ListNode fakeHead = new ListNode(0);
		fakeHead.next = head;
		ListNode n = fakeHead;

		while (n.next != null) {
			n = n.next;
			count++;
			if (count == len) {
				break;
			}
		}
		return count == len;
	}

	private void reverseInRange(ListNode preLast, ListNode head, int len) {
		ListNode fakeHead = new ListNode(0);
		fakeHead.next = head;

		int count = 0;
		ListNode pre = null;
		ListNode cur = head;
		ListNode next = null;
		while (count < len) {
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
			count++;
		}
		preLast.next = pre;
		head.next = next;
	}
}
