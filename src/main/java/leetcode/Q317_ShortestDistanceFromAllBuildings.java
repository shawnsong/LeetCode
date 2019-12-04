package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Q317_ShortestDistanceFromAllBuildings {
    public int shortestDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] reached = new int[m][n];
        int[][] dist = new int[m][n];

        int total = 0;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 1) {
                    continue;
                }

                total++;
                boolean[][] visited = new boolean[m][n];
                Queue<int[]> queue = new LinkedList<>();
                queue.add(new int[] {i, j});
                visited[i][j] = true;
                int step = 1;
                while (!queue.isEmpty()) {
                    int size = queue.size();
                    for (int k = 0; k < size; k++) {
                        int[] cur = queue.poll();
                        for (int[] dir : dirs) {
                            int x = cur[0] + dir[0];
                            int y = cur[1] + dir[1];
                            if (x < 0 || x == m || y < 0 || y == n || visited[x][y] || grid[x][y] != 0) {
                                continue;
                            }
                            visited[x][y] = true;
                            queue.add(new int[] {x, y});
                            reached[x][y]++;
                            dist[x][y] += step;
                        }
                    }
                    step++;
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (reached[i][j] == total) {
                    min = Math.min(min, dist[i][j]);
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
