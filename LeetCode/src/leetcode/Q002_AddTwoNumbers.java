package leetcode;

/*
 You are given two linked lists representing two non-negative numbers. 
 The digits are stored in reverse order and each of their nodes contain a single digit. 
 Add the two numbers and return it as a linked list.

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 */
public class Q002_AddTwoNumbers {
	public static void main(String[] a) {
		ListNode l1 = new ListNode(9);
		l1.next = new ListNode(9);
		ListNode l2 = new ListNode(9);
		l2.next = new ListNode(9);
		ListNode r = addTwoNumbers(l1, l2);
	}
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode n1 = l1;
		ListNode n2 = l2;
		ListNode fakeHead = new ListNode(0);
		ListNode pre = fakeHead;
		
		int carry = 0;
		
		while (n1 != null || n2 != null) {
			int sum = 0;
			if (n1 != null) {
				sum += n1.val;
				n1 = n1.next;
			}
			if (n2 != null) {
				sum += n2.val;
				n2 = n2.next;
			}
			sum += carry;
			if (sum > 9) {
				sum = sum - 10;
				carry = 1;
			} else
				carry = 0;
			pre.next = new ListNode(sum);
			pre = pre.next;
		}
		
		
		if (carry == 1) {
			pre.next = new ListNode(1);
		}
		return fakeHead.next;
	}
}
