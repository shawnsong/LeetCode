package leetcode;

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
