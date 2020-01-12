package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * A 2d grid map of m rows and n columns is initially filled with water. We may perform an addLand operation which turns
 * the water at position (row, col) into a land. Given a list of positions to operate, count the number of islands after
 * each addLand operation. An island is surrounded by water and is formed by connecting adjacent lands horizontally or
 * vertically. You may assume all four edges of the grid are all surrounded by water.
 */
public class Q305_NumberOfIslandsII {

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int[] roots = new int[m * n];
        Arrays.fill(roots, -1);
        List<Integer> res = new LinkedList<>();
        int count = 0;
        for (int[] pos : positions) {
            int curRoot = pos[0] * n + pos[1];
            if (roots[curRoot] != -1) {
                res.add(res.get(res.size() - 1));
                continue;
            }
            roots[curRoot] = curRoot;
            count++;
            for (int[] dir : dirs) {
                int i = pos[0] + dir[0];
                int j = pos[1] + dir[1];
                int nb = i * n + j;
                if (i < 0 || i == m || j < 0 || j == n || roots[nb] == -1) continue;
                int newRoot = findRoot(roots, nb);
                if (curRoot != newRoot) {
                    count--;
                    roots[curRoot] = newRoot;
                    curRoot = newRoot;
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