package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Q1036_EscapeLargeMaze {
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        int m = 1000000;
        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> blocks = new HashSet<>();

        for (int[] block : blocked) {
            int point = block[0] * m + block[1];
            blocks.add(point);
        }

        return bfs(source, target, blocks, m) && bfs(target, source, blocks, m);
    }

    boolean bfs(int[] source, int[] target, Set<Integer> blocks, int m) {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Set<Integer> seen = new HashSet<>();
        seen.add(source[0] * m + source[1]);
        Queue<int[]> queue = new LinkedList<>();
        queue.add(source);
        int steps = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] dir : dirs) {
                int xx = cur[0] + dir[0];
                int yy = cur[1] + dir[1];
                if (xx < 0 || xx == m || yy < 0 || yy == m ||
                        seen.contains(xx * m + yy) || blocks.contains(xx * m + yy)) {
                    continue;
                }
                if (xx == target[0] && yy == target[1]) {
                    return true;
                }
                seen.add(xx * m + yy);
                steps++;
                if (steps == 20000) {
                    return true;
                }
                queue.add(new int[] {xx, yy});
            }
        }
        return false;
    }
}
