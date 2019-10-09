package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q369_PlusOneLinkedListTest {
    Q369_PlusOneLinkedList test = new Q369_PlusOneLinkedList();

    @Test
    void plusOne() {
        ListNode root = new ListNode(9);
        assertEquals(1, test.plusOne(root).val);

        root.val = 1;
        root.next = new ListNode(2);
        assertEquals(3, test.plusOne(root).next.val);

        root.val = 2;
        root.next.val = 9;
        assertEquals(3, test.plusOne(root).val);
        assertEquals(0, root.next.val);
    }
}