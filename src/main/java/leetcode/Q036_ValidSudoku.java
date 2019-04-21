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
                if (board[i][j] != '.') continue;
                for (char num = '1'; num <= '9'; num++) {
                    if (canPut(board, i, j, num)) {
                        board[i][j] = num;
                        boolean solved = solve(board);
                        if (solved) return true;
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }

    private boolean canPut(char[][] board, int row, int col, char num) {

        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num)
                return false;
        }
        int rowIdx = row / 3 * 3, colIdx = col / 3 * 3;
        for (int i = rowIdx; i < rowIdx + 3; i++) {
            for (int j = colIdx; j < colIdx + 3; j++) {
                if (board[i][j] == num) return false;
            }
        }
        return true;
    }
}
