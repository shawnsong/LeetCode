package leetcode;

/*
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class Q109_ConvertSortedListToBinarySearchTree {
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;
		
		ListNode slow = head;
		ListNode fast = head;
		ListNode fakeHead = new ListNode(0);
		ListNode pre = fakeHead;
		fakeHead.next = head;
		while(fast != null && fast.next != null) {
			pre = slow;
			fast = fast.next.next;
			slow = slow.next;
		}
		
		// slow is mid
		pre.next = null;
		ListNode left = fakeHead.next;
		ListNode right = slow.next;
		
		slow.next = null;
		TreeNode root = new TreeNode(slow.val);
		root.left = sortedListToBST(left);
		root.right = sortedListToBST(right);
		
		return root;
	}
}
