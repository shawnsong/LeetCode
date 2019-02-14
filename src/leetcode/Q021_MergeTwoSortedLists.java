package leetcode;

/* 
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 */
public class Q021_MergeTwoSortedLists {

	public ListNode merge(ListNode l1, ListNode l2) {
		if (l1 == null || l2 == null)
			return l1 == null ? l2 : l1;
		
		ListNode fakeHead = new ListNode(0);
		ListNode pre = fakeHead;
		
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				pre.next = l1;
				pre = l1;
				l1 = l1.next;
			} else {
				pre.next = l2;
				pre = l2;
				l2 = l2.next;
			}
		}
		
		pre.next = l1 == null ? l2 : l1;
		
		return fakeHead.next;
	}
}
