package leetcode;

/*
Given a linked list and a value x, partition it such that all nodes less than x come before 
nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5. 
 */
public class Q086_PartitionList {
	public ListNode partition(ListNode head, int x) {
		ListNode leftFakeHead = new ListNode(0);
		ListNode rightFakeHead = new ListNode(0);
		
		ListNode left = leftFakeHead;
		ListNode right = rightFakeHead;
		
		ListNode n = head;
		ListNode next = null;
		while (n != null) {
			next = n.next;
			if (n.val < x) {
				left.next = n;
				left = n;
			} else {
				right.next = n;
				right = n;
			} 
			n.next = null;
			n = next;
		}
		
		left.next = rightFakeHead.next;
		
		return leftFakeHead.next;
	}
}
