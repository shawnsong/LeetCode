package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q305_NumberOfIslandsII {

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new LinkedList<>();
        int[] roots = new int[m * n];

        Arrays.fill(roots, -1);

        int[][] steps = { {-1, 0}, {1, 0}, {0, 1}, {0, -1} };

        int count = 0;
        for (int[] pos : positions) {
            int rowIdx = pos[0];
            int colIdx = pos[1];
            int idx = rowIdx * n + colIdx;
            roots[idx] = idx;

            count++;
            for (int[] step : steps) {
                int nextRowIdx = rowIdx + step[0];
                int nextColIdx = colIdx + step[1];
                int nextIdx = nextRowIdx * n + nextColIdx;
                if (nextRowIdx < 0 || nextRowIdx == m || nextColIdx < 0 || nextColIdx == n || roots[nextIdx] == -1) {
                    continue;
                }
                int rootOfNb = findRoot(roots, nextRowIdx);
                if (rootOfNb != idx) {
                    roots[idx] = rootOfNb;
                    count--;
                }
            }
            res.add(count);
        }
        return res;
    }

    private int findRoot(int[] roots, int node) {
        while (roots[node] != node) {
            int parent = roots[node];
            roots[node] = roots[parent];
            node = roots[node];
        }
        return node;
    }
}