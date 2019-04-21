package leetcode;


/**
 * 1,  -2,  -5,  -4
 * -1, -5,  10,   1
 * -2,  1,  -3,   0
 */
public class Q174_DungeonGame {
    public int minHp(int[][] board) {
        int m = board.length, n = board[0].length;

        int[][] minHp = new int[m][n];
        minHp[m-1][n-1] = 1;
        // minHp[i][j] = Math.min(minHp[i+1][j], minHp[i][j+1]) - board[i][j];
        // if (minHp[i][j] <= 0) minHp[i][j] = 1;

        minHp[m - 1][n - 1] = Math.max(1, 1 - board[m - 1][n - 1]);
        for (int i = m - 2; i >= 0; i--) {
            minHp[i][n - 1] = Math.max(1, minHp[i + 1][n - 1] - board[i][n - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            minHp[m-1][i] = Math.max(1, minHp[m-1][i + 1] - board[m-1][i]);
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int fromRight = Math.max(1, minHp[i][j+1] - board[i][j]);
                int fromBot = Math.max(1, minHp[i + 1][j] - board[i][j]);
                minHp[i][j] = Math.min(fromRight, fromBot);
            }
        }
        return minHp[0][0];
    }
}
