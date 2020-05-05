package leetcode;

import java.util.HashMap;
import leetcode.models.RandomListNode;

/*
A linked list is given such that each node contains an additional random pointer 
which could point to any node in the list or null.

Return a deep copy of the list. 
*/
public class Q138_CopyListWithRandomPointer {
	
	// use hashtable
	public RandomListNode copyRandomList2(RandomListNode head) {
		if (head == null)
			return null;
		RandomListNode n1 = head;
		
		RandomListNode fakeHead = new RandomListNode (0);
		RandomListNode pre = fakeHead;
		HashMap<RandomListNode, RandomListNode> map = new HashMap();
		while (n1 != null) {
			RandomListNode n2 = new RandomListNode(n1.label);
			pre.next = n2;
			pre = n2;
			map.put(n1, n2);
			n1 = n1.next;
		}
		
		n1 = head;
		while (n1 != null) {
			if (n1.random != null) {
				RandomListNode n2 = map.get(n1);
				n2.random = map.get(n1.random);
			}
			n1 = n1.next;
		}
		
		return fakeHead.next;
	}
	
	// copy the list
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null)
			return null;
		
		RandomListNode n1 = head;
		RandomListNode next = null;
		
		// make a copy of each node after itself
		while (n1 != null) {
			next = n1.next;
			n1.next = new RandomListNode(n1.label);
			n1.next.next = next;
			
			n1 = next;
		}
		
		
		// copy the random pointer
		RandomListNode n2 = null;
		n1 = head;
		while (n1 != null) {
			n2 = n1.next;
			
			if (n1.random != null)
				n2.random = n1.random.next;
			n1 = n2.next;
		}
		
		// break the list
		n1 = head;
		RandomListNode newHead = new RandomListNode(0);
		RandomListNode n2Prev = newHead;
		while (n1 != null) {
			n2 = n1.next;
			n1.next = n2.next;
			n1 = n1.next;
			
			n2Prev.next = n2;
			n2Prev = n2;
		}
		
		return newHead.next;
	}
}
