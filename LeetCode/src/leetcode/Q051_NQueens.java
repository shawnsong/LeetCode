package leetcode;

import java.util.LinkedList;
import java.util.List;

/*
 The n-queens puzzle is the problem of placing n queens on an n¡Án chessboard 
 such that no two queens attack each other.

 Given an integer n, return all distinct solutions to the n-queens puzzle.

 Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' 
 both indicate a queen and an empty space respectively.

 For example,
 There exist two distinct solutions to the 4-queens puzzle:

 [
 [
 ".Q..",  // Solution 1
 "...Q",
 "Q...",
 "..Q."],

 [
 "..Q.",  // Solution 2
 "Q...",
 "...Q",
 ".Q.."]
 ]

 */
public class Q051_NQueens {
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> res = new LinkedList();
		if (n == 1) {
			List<String> list = new LinkedList();
			list.add("Q");
			res.add(list);
			return res;
		}
		if (n < 4)
			return res;

		char[][] board = new char[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				board[i][j] = '.';

		solve(board, 0, res);
		return res;
	}

	private void solve(char[][] board, int rowIdx, List<List<String>> res) {
		int n = board.length;
		if (rowIdx == n) {
			List<String> tmpRes = new LinkedList();
			for (int i = 0; i < n; i++) {
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < n; j++)
					sb.append(board[i][j]);
				tmpRes.add(sb.toString());
			}
			res.add(tmpRes);
			return;
		}

		for (int i = 0; i < n; i++) {
			if (canPut(board, i, rowIdx, n)) {
				board[rowIdx][i] = 'Q';
				solve(board, rowIdx + 1, res);
				board[rowIdx][i] = '.';
			}
		}
	}

	private boolean canPut(char[][] board, int column, int row, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == row && board[i][j] == 1)
					return false;
				if (j == column && board[i][j] == 1)
					return false;
				if ((Math.abs(row - i) == Math.abs(column - j))
						&& (board[i][j] == 1))
					return false;
			}
		}
		return true;
	}
}
