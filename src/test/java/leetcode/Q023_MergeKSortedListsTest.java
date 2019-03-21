package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q023_MergeKSortedListsTest {

    Q023_MergeKSortedLists test = new Q023_MergeKSortedLists();

    @Test
    void test() {
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode( 4);
        ListNode n2 = new ListNode(2);
        n2.next = new ListNode(3);
        ListNode n3 = new ListNode(7);

        ListNode merged = test.mergeKLists((ListNode[]) Arrays.asList(n1, n2, n3).toArray());
        List<Integer> res = new LinkedList();

        while (merged != null) {
            res.add(merged.val);
            merged = merged.next;
        }

        assertEquals(Arrays.asList(1, 2, 3, 4, 7), res);
    }
}