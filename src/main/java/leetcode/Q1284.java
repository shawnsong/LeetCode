package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Q1284 {
    public int minFlips(int[][] mat) {
        StringBuilder sb = new StringBuilder();
        int m = mat.length, n = mat[0].length;
        for (int i = 0; i < m * n; i++) {
            sb.append("0");
        }
        String end = sb.toString();
        if (toString(mat).equals(end)) {
            return 0;
        }

        Queue<int[][]> queue = new LinkedList<>();
        queue.add(mat);
        Set<String> seen = new HashSet<>();
        seen.add(toString(mat));
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                int[][] cur = queue.poll();
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        int[][] next = flip(mat, i, j);
                        String nextStr = toString(next);
                        if (nextStr.equals(end)) {
                            return steps + 1;
                        }
                        if (seen.contains(nextStr)) {
                            continue;
                        }
                        seen.add(nextStr);
                        queue.add(next);
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    int[][] flip(int[][] old, int row, int col) {
        int m = old.length, n = old[0].length;
        int[][] mat = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = old[i][j];
            }
        }
        mat[row][col] = 1 - mat[row][col];
        if (row > 0) {
            mat[row-1][col] = 1 - mat[row-1][col];
        }
        if (row < mat.length - 1) {
            mat[row+1][col] = 1 - mat[row+1][col];
        }
        if (col > 0) {
            mat[row][col-1] = 1 - mat[row][col - 1];
        }
        if (col < mat[0].length - 1) {
            mat[row][col + 1] = 1 - mat[row][col+ 1];
        }
        return mat;
    }

    String toString(int[][] mat) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                sb.append(mat[i][j]);
            }
        }
        return sb.toString();
    }
}
