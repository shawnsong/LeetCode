package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q947_947MostStonesRemovedWithSameRowOrColumn {
    public int removeStones(int[][] stones) {
        if (stones == null || stones.length == 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int[] stone : stones) {
            int row = stone[0];
            int col = stone[1] + 10000;
            if (map.putIfAbsent(row, row) == null) {
                count++;
            }
            if (map.putIfAbsent(col, col) == null) {
                count++;
            }
            int x = findRoot(map, row);
            int y = findRoot(map, col);
            if (x != y) {
                count--;
                map.put(x, y);
            }
        }
        return stones.length - count;
    }

    int findRoot(Map<Integer, Integer> roots, int node) {
        while (roots.get(node) != node) {
            node = roots.get(node);
        }
        return node;
    }
}
