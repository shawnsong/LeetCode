package leetcode;

/**
 * Reverse a linked list from position m to n. Do it in one-pass.
 *
 * Note: 1 ≤ m ≤ n ≤ length of list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Q092_ReverseLinkedListII {


    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode prev = fakeHead;
        ListNode cur = head;
        int count = 1;
        while (count < m) {
            prev = cur;
            cur = cur.next;
            count++;
        }

        ListNode nodeBeforeReverse = prev;
        while (count <= n) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        nodeBeforeReverse.next.next = cur;
        nodeBeforeReverse.next = prev;
        return fakeHead.next;
    }

    /**
     * Solultion 2: find the start and the end of the list that needs to be reversed. Reverse the list and
     * put it back to the original list
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween2(ListNode head, int m, int n) {
		if (head == null || head.next == null)
			return head;
		
		ListNode fakeHead = new ListNode(0);
		ListNode pre = fakeHead;
		pre.next = head;
		ListNode cur = head;
		int count= 1;
		while (count < m) {
			pre = cur;
			cur = cur.next;
			count++;
		}
		pre.next = null;
		ListNode partHead = cur;
		while (count < n) {
			cur = cur.next;
			count++;
		}
		ListNode next = cur.next;
		cur.next = null;
		
		ListNode newPartHead = reverse(partHead);
		pre.next = newPartHead;
		partHead.next = next;
		return fakeHead.next;
	}
	
	private ListNode reverse(ListNode head) {
		ListNode cur = head;
		ListNode pre = null;
		while (cur != null) {
			ListNode next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		
		return pre;
	}
}
