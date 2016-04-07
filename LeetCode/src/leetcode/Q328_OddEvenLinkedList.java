package leetcode;

/*
 Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are 
 talking about the node number and not the value in the nodes.

 You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

 Example:
 Given 1->2->3->4->5->NULL,
 return 1->3->5->2->4->NULL.

 Note:
 The relative order inside both the even and odd groups should remain as it was in the input. 
 The first node is considered odd, the second node even and so on ...
 */
public class Q328_OddEvenLinkedList {
	public ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		
		ListNode odd = new ListNode(0);
		ListNode even = new ListNode(0);
		
		ListNode n1 = odd;
		ListNode n2 = even;
		
		int count = 0;
		ListNode n = head;
		while (n != null) {
			count++;
			ListNode next = n.next;
			if (count % 2 == 1) {
				n1.next = n;
				n1 = n1.next;
			} else {
				n2.next = n;
				n2 = n2.next;
			}
		    n.next = null;
		    n = next;
		}
		
		n1.next = even.next;
		return odd.next;
	}
}
