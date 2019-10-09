package leetcode;

public class Q369_PlusOneLinkedList {
    ListNode plusOne(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode left = fakeHead, right = fakeHead;

        while (right.next != null) {
            if (right.val != 9) {
                left = right;
            }
            right = right.next;
        }

        if (right.val != 9) {
            right.val++;
            return head;
        }
        left.val++;
        left = left.next;
        while (left != null) {
            left.val = 0;
            left = left.next;
        }
        if (fakeHead.val == 0) {
            return head;
        }
        return fakeHead;
    }
}
