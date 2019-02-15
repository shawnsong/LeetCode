package leetcode;

/*
 Write a program to find the node at which the intersection of two singly linked lists begins.


 For example, the following two linked lists:

 A:          a1 ¡ú a2
  					  ¨K
 					   c1 ¡ú c2 ¡ú c3
 					  ¨J
 B:     b1 ¡ú b2 ¡ú b3
 begin to intersect at node c1.


 Notes:

 If the two linked lists have no intersection at all, return null.
 The linked lists must retain their original structure after the function returns.
 You may assume there are no cycles anywhere in the entire linked structure.
 Your code should preferably run in O(n) time and use only O(1) memory.
 */
public class Q160_IntersectionofTwoLinkedLists {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int len1 = getLength(headA);
		int len2 = getLength(headB);

		ListNode l1 = headA;
		ListNode l2 = headB;

		if (len1 > len2) {
			int count = 0;
			while (count < len1 - len2) {
				l1 = l1.next;
				count++;
			}
		} else if (len1 < len2) {
			int count = 0;
			while (count < len2 - len1) {
				l2 = l2.next;
				count++;
			}
		}
		
		while (l1 != null && l1 != l2) {
			l1 = l1.next;
			l2 = l2.next;
		}
		if (l1 != null)
			return l1;
		return null;
	}

	private int getLength(ListNode l) {
		int count = 0;
		while (l != null) {
			l = l.next;
			count++;
		}
		return count;
	}
}
