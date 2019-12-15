package leetcode;

import java.util.List;
import java.util.PriorityQueue;

public class Q632_SmallestRangeCoveringElementsFromKLists {
    public int[] smallestRange(List<List<Integer>> nums) {
        int[] res = {Integer.MAX_VALUE, Integer.MIN_VALUE};

        int k = nums.size();

        int max = Integer.MIN_VALUE;
        PriorityQueue<IndexVal> pq = new PriorityQueue<>((i1, i2) -> i1.val - i2.val);
        for (int i = 0; i < k; i++) {
            List<Integer> list = nums.get(i);
            pq.add(new IndexVal(i, 0, list.get(0)));
            res[0] = Math.min(res[0], list.get(0));
            res[1] = Math.max(res[1], list.get(0));
            max = Math.max(max, res[1]);
        }


        while (true) {
            IndexVal cur = pq.poll();
            if (max - cur.val < res[1] - res[0]) {
                res[0] = cur.val;
                res[1] = max;
            }
            if (cur.itemIdx + 1< nums.get(cur.listIdx).size()) {
                IndexVal next = new IndexVal(cur.listIdx, cur.itemIdx + 1, nums.get(cur.listIdx).get(cur.itemIdx + 1));
                max = Math.max(next.val, max);
                pq.add(next);
            } else {
                break;
            }
        }
        return res;
    }

    class IndexVal {
        int listIdx;
        int itemIdx;
        int val;
        IndexVal(int l, int i, int v) {
            listIdx = l;
            itemIdx = i;
            val = v;
        }
    }
}
