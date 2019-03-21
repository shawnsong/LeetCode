package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q023_MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ArrayList<ListNode> nodes = new ArrayList<>();
        for (ListNode list : lists) {
            if (list != null) {
                nodes.add(list);
            }
        }

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(n -> n.val));
        for (ListNode node : nodes) {
            minHeap.add(node);
        }

        ListNode fakeHead = new ListNode(0);
        ListNode cur = fakeHead;
        while (!minHeap.isEmpty()) {
            ListNode next = minHeap.poll();
            cur.next = next;
            cur = cur.next;


            if (next.next != null) {
                minHeap.add(next.next);
            }
        }
        return fakeHead.next;
    }

}
