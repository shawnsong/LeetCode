package leetcode;

public class Q036_ValidSudoku {

    public void solveSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return;
        }

        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    continue;
                }
                for (char num = '1'; num <= '9'; num++) {
                    if (canPut(board, num, i, j)) {
                        board[i][j] = num;
                        if (solve(board)) {
                            return true;
                        }
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }

    private boolean canPut(char[][] board, char num, int rowIdx, int colIdx) {
        // check row
        for (int i = 0; i < 9; i++) {
            if (board[rowIdx][i] == num || board[i][colIdx] == num) {
                return false;
            }
        }
        // check square
        int rowStartIdx = rowIdx / 3 * 3, colStartIdx = colIdx / 3 * 3;
        for (int i = rowStartIdx; i < rowStartIdx + 3; i++) {
            for (int j = colStartIdx; j < colStartIdx + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }
}
