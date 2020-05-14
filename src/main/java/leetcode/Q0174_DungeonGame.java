package leetcode;


/**
 * 1,  -2,  -5,  -4
 * -1, -5,  10,   1
 * -2,  1,  -3,   0
 */
public class Q0174_DungeonGame {
    public int minHp(int[][] board) {
        int m = board.length, n = board[0].length;

        int[][] minHp = new int[m][n];
        minHp[m - 1][n - 1] = 1;

        for (int i = m - 2; i >= 0; i--) {
            minHp[i][n - 1] = Math.max(1, minHp[i+1][n-1] - board[i][n - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            minHp[m-1][i] = Math.max(1, minHp[m - 1][i + 1] - board[m - 1][i]);
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int min = Math.min(minHp[i + 1][j], minHp[i][j+1]);
                minHp[i][j] =  Math.max(1, min - board[i][j]);
            }
        }
        return minHp[0][0];
    }
}
