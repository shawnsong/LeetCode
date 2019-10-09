package leetcode;

public class Q329 {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int m = matrix.length, n = matrix[0].length;

        int[][] visited = new int[m][n];

        int max = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = dfs(matrix, i, j, visited, Integer.MIN_VALUE);
                max = Math.max(tmp, max);
            }
        }
        return max;
    }

    int dfs(int[][] matrix, int row, int col, int[][] visited, int prev) {
        if (row < 0 || row == visited.length || col < 0 || col == visited[0].length || matrix[row][col] <= prev) {
            return 0;
        }

        if (visited[row][col] != 0) {
            return visited[row][col];
        }

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] dir : dirs) {
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];
            int tmp = 1 + dfs(matrix, nextRow, nextCol, visited, matrix[row][col]);
            visited[row][col] = Math.max(visited[row][col], tmp);
        }

        return visited[row][col];
    }
}
