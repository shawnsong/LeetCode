package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Q1091 {

    private int dirs[][] = new int[][]{{0,1},{0,-1},{1,0},{-1,0},{1,-1},{-1,1},{-1,-1},{1,1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }
        int m = grid.length;
        int n = grid[0].length;
        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) {
            return -1;
        }
        if (m == 1 && n == 1) {
            return 1;
        }

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        queue.add(new int[]{0, 0});
        int steps = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] dir : dirs) {
                    int nextRow = cur[0] + dir[0];
                    int nextCol = cur[1] + dir[1];
                    if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n &&
                            grid[nextRow][nextCol] == 0 && !visited[nextRow][nextCol]) {
                        if (nextRow == m - 1 && nextCol == n - 1) {
                            return steps + 1;
                        }
                        visited[nextRow][nextCol] = true;
                        queue.add(new int[]{nextRow, nextCol});
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}
