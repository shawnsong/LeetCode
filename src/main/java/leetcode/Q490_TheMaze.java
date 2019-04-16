package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Q490_TheMaze {
    class Point {
        int row;
        int col;
        public Point (int r, int c) {
            row = r;
            col = c;
        }
    }

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0) return false;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(start[0], start[1]));

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int m = maze.length, n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            int row = p.row, col = p.col;

            for (int[] dir : dirs) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if (newRow >= m || newRow < 0 || newCol >= n || newCol < 0 ||
                    maze[newRow][newCol] == 0 || visited[newRow][newCol]) {
                    continue;
                }
                if (newRow == destination[0] && newCol == destination[1]) {
                    int nnewRow = newRow + dir[0];
                    int nnewCol = newCol + dir[1];
                    if (nnewRow >= maze.length || nnewRow < 0 || nnewCol >= maze[0].length || nnewCol < 0
                        || maze[nnewRow][nnewCol] == 0) {
                        return true;
                    }
                }
                queue.add(new Point(newRow, newCol));
                visited[newRow][newCol] = true;
            }
        }
        return false;
    }
}

