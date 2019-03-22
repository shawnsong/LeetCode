package leetcode;

/**
 *  Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 *
 *  If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 *
 *  You may not alter the values in the nodes, only nodes itself may be changed.
 *
 *  Only constant memory is allowed.
 *
 *  For example,
 *  Given this linked list: 1->2->3->4->5
 *
 *  For k = 2, you should return: 2->1->4->3->5
 *
 *  For k = 3, you should return: 3->2->1->4->5
 */
public class Q025_ReverseNodesInKGroups {

	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || k <= 0) {
			return head;
		}
		int count = 1;
		ListNode node = head;
		while (node != null) {
			node = node.next;
			if (node != null) {
				count++;
			}
			if (count == k) break;
		}
		if (count < k) {
			return head;
		}

		ListNode next = node.next;
		node.next = null;
		ListNode prev = null;
		node = head;
		while (node != null) {
			ListNode nnext = node.next;
			node.next = prev;
			prev = node;
			node = nnext;
		}
		head.next = reverseKGroup(next, k);
		return prev;
	}

}
