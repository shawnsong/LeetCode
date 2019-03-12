package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Q025_ReverseNodesInKGroupsTest {

    Q025_ReverseNodesInKGroups underTest = new Q025_ReverseNodesInKGroups();

    @Test
    public void reverseKGroup() {
        ListNode fakeHead = new ListNode(0);
        ListNode n = fakeHead;
        for (int i = 1; i <= 5; i++) {
            n.next = new ListNode(i);
            n = n.next;
        }

        ListNode reversed = underTest.reverseKGroup(fakeHead.next, 2);
        n = reversed;
        StringBuilder sb = new StringBuilder();
        while (n != null) {
            sb.append(n.val);
            n = n.next;
        }
        assertEquals("21435", sb.toString());
    }
}
