package leetcode;

import java.util.Random;

public class Q382_LinkedListRandomNode {
    ListNode head;
    Random random;

    Q382_LinkedListRandomNode(ListNode head) {
        this.head = head;
        random = new Random();
    }

    public int getRandom() {
        int idx = 0;
        ListNode node = head;
        int res = node.val;
        while (node != null) {
            int tmp = random.nextInt(idx + 1);
            if (tmp == idx) {
                res = node.val;
            }
            node = node.next;
            idx++;
        }
        return res;
    }
}
