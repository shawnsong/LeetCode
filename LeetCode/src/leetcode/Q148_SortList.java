package leetcode;

public class Q148_SortList {
	
	public ListNode sortList(ListNode head) {
		
		if (head == null || head.next == null)
			return head;
		
		if (head.next.next == null) {
			if (head.val < head.next.val)
				return head;
			else {
				ListNode ret = head.next;
				ret.next= head;
				head.next = null;
				return ret;
			}
		}
		
		ListNode slow = head;
		ListNode fast = head;
		
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		ListNode l1 = head;
		ListNode l2 = slow.next;
		slow.next = null;
		
		ListNode sortedL1 = sortList(l1);
		ListNode sortedL2 = sortList(l2);
		
		ListNode merged = mergeList(sortedL1, sortedL2);
		return merged;
	}
	
	private ListNode mergeList(ListNode list1, ListNode list2) {
		ListNode fakeHead = new ListNode(0);
		ListNode pre = fakeHead;
		ListNode l1 = list1;
		ListNode l2 = list2;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				pre.next = l1;
				l1 = l1.next;
			} else {
				pre.next = l2;
				l2 = l2.next;
			}
			pre = pre.next;
		}
		
		if (l1 != null)
			pre.next = l1;
		
		if (l2 != null)
			pre.next = l2;
		return fakeHead.next;
	}
}
