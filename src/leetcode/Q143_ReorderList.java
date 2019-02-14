package leetcode;
/*
Given a singly linked list L: L0¡úL1¡ú¡­¡úLn-1¡úLn,
reorder it to: L0¡úLn¡úL1¡úLn-1¡úL2¡úLn-2¡ú¡­

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}. 
 */
public class Q143_ReorderList {

	public void reorderList(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		ListNode l2 = slow.next;
		slow.next = null;
		ListNode n2 = reverse(l2);
		ListNode n1 = head;
		
		ListNode nn1;
		ListNode nn2;
		
		while (n2 != null) {
			nn1 = n1.next;
			nn2 = n2.next;
			n1.next = n2;
			n2.next = nn1;
			
			n1 = nn1;
			n2 = nn2;
		}
	}
	
	public ListNode reverse(ListNode head) {
		
		ListNode pre = null;
		ListNode cur = head;
		ListNode next = null;
		
		while (cur != null) {
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		
		return pre;
	}
}
