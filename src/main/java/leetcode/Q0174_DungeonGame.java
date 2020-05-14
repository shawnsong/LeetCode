package leetcode;


/**
 * 1,  -2,  -5,  -4
 * -1, -5,  10,   1
 * -2,  1,  -3,   0
 */
public class Q0174_DungeonGame {
    public int minHp(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        int[][] mins = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    mins[i][j] = Math.max(1, 1 - board[i][j]);
                } else if (i == m - 1) {
                    mins[i][j] = Math.max(1, mins[i][j+1] - board[i][j]);
                } else  if (j == n - 1) {
                    mins[i][j] = Math.max(1, mins[i+1][j] - board[i][j]);
                } else {
                  mins[i][j] = Math.max(1, Math.min(mins[i+1][j], mins[i][j+1]) - board[i][j]);
                }
            }
        }
        return mins[0][0];
    }
}
