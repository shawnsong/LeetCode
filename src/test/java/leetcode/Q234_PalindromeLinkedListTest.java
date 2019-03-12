package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q234_PalindromeLinkedListTest {

    Q234_PalindromeLinkedList underTest = new Q234_PalindromeLinkedList();

    @Test
    void isPalindrome() {
        // 1
        ListNode node = new ListNode(1);
        assertTrue(underTest.isPalindrome(node));

        // 1,1
        node.next = new ListNode(1);
        assertTrue(underTest.isPalindrome(node));

        // 1,2,1
        node.next = new ListNode(2);
        node.next.next = new ListNode(1);
        assertTrue(underTest.isPalindrome(node));

        // 1,2,2,1
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(1);
        assertTrue(underTest.isPalindrome(node));

        node.next.next.next = new ListNode(3);
        assertFalse(underTest.isPalindrome(node));
    }

    @Test
    void reverse() {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node = underTest.reverse(node);
        int value = 4;
        while (node != null) {
            assertEquals(value, node.val);
            value--;
            node = node.next;
        }
    }
}