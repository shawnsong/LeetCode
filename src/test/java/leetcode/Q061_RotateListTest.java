package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q061_RotateListTest {

    @Test
    void rotateRight() {
        Q061_RotateList underTest = new Q061_RotateList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);

        underTest.rotateRight(head, 1);
    }
}