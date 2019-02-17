package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q024_SwapNodesInPairsTest {


    Q024_SwapNodesInPairs underTest = new Q024_SwapNodesInPairs();

    @Test
    void swapPairs() {
        ListNode fakeHead = new ListNode(0);
        ListNode n = fakeHead;
        for (int i = 0; i < 4; i++) {
            n.next = new ListNode(i + 1);
            n = n.next;
        }

        StringBuilder sb = new StringBuilder();
        n = fakeHead.next;
        while (n != null) {
            sb.append(n.val);
            n = n.next;
        }
        assertEquals("1234", sb.toString());
        ListNode swapped = underTest.swapPairs(fakeHead.next);

        n = swapped;
        sb = new StringBuilder();
        while (n != null) {
            sb.append(n.val);
            n = n.next;
        }
        assertEquals("2143", sb.toString());
    }
}