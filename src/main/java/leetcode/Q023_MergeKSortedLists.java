package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q023_MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        }

        ListNode fakeHead = new ListNode(0);
        ListNode cur = fakeHead;
        PriorityQueue<ListNode> heap = new PriorityQueue(new Comparator<ListNode>() {
            public int compare(ListNode l1, ListNode l2) {
                if (l1.val == l2.val) {
                    return 0;
                } else if (l1.val < l2.val) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                heap.add(lists[i]);
            }
        }

        while (!heap.isEmpty()) {
            ListNode node = heap.poll();
            cur.next = node;
            cur = cur.next;

            if (node.next != null) {
                heap.add(node.next);
            }
        }

        return fakeHead.next;
    }

}
