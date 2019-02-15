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
			List tmp = new LinkedList<String>();
			tmp.add("Q");
			res.add(tmp);
			return res;
		}
		if (n <= 3)
			return res;

		char[][] board = new char[n][n];
		for (int i = 0; i< n; i++)
			for (int j = 0; j < n; j++)
				board[i][j] = '.';
		solve(board, 0, res);

		return res;
	}

	private void solve(char[][] board, int index, List<List<String>> res) {
		if (index == board.length) {
			// add to res
			List<String> line = new LinkedList();
			for (int i = 0; i < board.length; i++) {
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < board.length; j++) {
					sb.append(board[i][j]);
				}
				line.add(sb.toString());
			}
			res.add(line);
			return;
		}

		for (int i = 0; i < board.length; i++) {
			if (canPut(board, index, i)) {
				board[index][i] = 'Q';
				solve(board, index + 1, res);
				board[index][i] = '.';
			}
		}
	}

	private boolean canPut(char[][] board, int rowIdx, int columnIdx) {
		for (int i = 0; i < rowIdx; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] == 'Q') {
					if (j == columnIdx)
						return false;
					if (Math.abs(rowIdx - i) == Math.abs(columnIdx - j) ) {
						return false;
					}
				}
			}
		}
		return true;
	}
}
