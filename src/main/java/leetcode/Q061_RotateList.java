package leetcode;

/*
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
 */
public class Q061_RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        int len = getListLength(head);
        if (k % len == 0) {
            return head;
        }

        k = k % len;
        int count = 1;
        ListNode n = head;
        while (count < k) {
            n = n.next;
            count++;
        }
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode slow = fakeHead;
        while (n.next != null) {
            slow = slow.next;
            n = n.next;
        }
        ListNode next = slow.next;
        slow.next = null;
        n.next = head;
        return next;
    }

    private int getListLength(ListNode head) {
        ListNode n = head;
        int count = 0;
        while (n != null) {
            n = n.next;
            count++;
        }
        return count;
    }
}
