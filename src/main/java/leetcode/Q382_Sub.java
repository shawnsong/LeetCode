package leetcode;

import java.util.Random;

public class Q382_Sub {
    ListNode head;
    Random rand;
    int k;

    public Q382_Sub(ListNode head, int k) {
        this.head = head;
        rand = new Random();
        this.k = k;
    }

    public int[] getRandom() {
        int[] res = new int[k];
        ListNode node = head;
        int idx = 0;
        while (node != null) {
            if (idx < k) {
                res[idx] = node.val;
            } else {
                int tmp = rand.nextInt(idx + 1);
                // If the randomly  picked index is smaller than k,
                // then replace the element present at the index
                // with new element from stream
                if (tmp < k) {
                    res[idx] = node.val;
                }
            }
            node = node.next;
            idx++;
        }
        return res;
    }
}
