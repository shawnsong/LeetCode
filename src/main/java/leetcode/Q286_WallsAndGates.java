package leetcode;

/**
 * You are given a m x n 2D grid initialized with these three possible values.
 *
 * -1 - A wall or an obstacle.
 * 0 - A gate.
 * INF - Infinity means an empty room. We use the value 2^31 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
 * Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
 *
 * Example:
 *
 * Given the 2D grid:
 *
 * INF  -1  0  INF
 * INF INF INF  -1
 * INF  -1 INF  -1
 *   0  -1 INF INF
 * After running your function, the 2D grid should be:
 *
 *   3  -1   0   1
 *   2   2   1  -1
 *   1  -1   2  -1
 *   0  -1   3   4
 */
public class Q286_WallsAndGates {

    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0) {
            return;
        }

        int m = rooms.length, n = rooms[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(rooms[i][j] != Integer.MAX_VALUE) {
                    continue;
                }
                rooms[i][j] = walkAround(rooms, i, j);
            }
        }
    }

    private int walkAround(int[][] rooms, int rowIdx, int colIdx) {
        if (rowIdx < 0 || rowIdx == rooms.length || colIdx < 0 || colIdx == rooms[0].length) {
            return Integer.MAX_VALUE;
        }

        if (rooms[rowIdx][colIdx] == 0) {
            return 0;
        }
        if (rooms[rowIdx][colIdx] == -1) {
            return Integer.MAX_VALUE;
        }

        if (rooms[rowIdx][colIdx] >= 0 && rooms[rowIdx][colIdx] < Integer.MAX_VALUE) {
            return rooms[rowIdx][colIdx];
        }
        rooms[rowIdx][colIdx] = -1;

        int min = Integer.MAX_VALUE;
        min = Math.min(min, walkAround(rooms, rowIdx + 1, colIdx));
        min = Math.min(min, walkAround(rooms, rowIdx - 1, colIdx));
        min = Math.min(min, walkAround(rooms, rowIdx, colIdx + 1));
        min = Math.min(min, walkAround(rooms, rowIdx, colIdx - 1));

        rooms[rowIdx][colIdx] = Integer.MAX_VALUE;
        return min == Integer.MAX_VALUE ? Integer.MAX_VALUE : min + 1;
    }
}
