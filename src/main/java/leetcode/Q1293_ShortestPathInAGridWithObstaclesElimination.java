package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Q1293_ShortestPathInAGridWithObstaclesElimination {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;

        return shortestPath(grid, 0, 0, k, visited, new HashMap<>());
    }

    public int shortestPath(int[][] grid, int startIdx, int endIdx, int k, boolean[][] visited, Map<String, Integer> cache) {
        int m = grid.length;
        int n = grid[0].length;
        if (startIdx == m - 1 && endIdx == n - 1) {
            return 0;
        }

        String key = startIdx + "-" + endIdx + "-" + k;

        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startIdx, endIdx});
        int res = m * n;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean found = false;
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] dir : dirs) {
                    int x = dir[0] + cur[0];
                    int y = dir[1] + cur[1];
                    if (x < 0 || x == m || y < 0 || y == n || visited[x][y]) {
                        continue;
                    }
                    if (grid[x][y] == 1) {
                        grid[x][y] = 0;
                        if (k > 0) {
                            boolean[][] c= new boolean[m][n];
                            for (int j = 0; j < m; j++) {
                                for (int l = 0; l < n; l++) {
                                    c[j][l] = visited[j][l];
                                }
                            }
                            c[x][y] = true;
                            int tmp = shortestPath(grid, x, y, k - 1, c, cache);
                            if (tmp != -1) {
                                res = Math.min(res, tmp + steps + 1);
                            }
                        }
                        grid[x][y] = 1;
                    } else {
                        if (x == m - 1 && y == n - 1) {
                            res = Math.min(res, steps + 1);
                            found = true;
                        }
                        visited[x][y] = true;
                        queue.add(new int[]{x, y});
                    }
                }
            }
            if (found) {
                break;
            }
            steps++;
        }

        cache.put(key, res);
        return res == m * n ? -1 : res;
    }
}
