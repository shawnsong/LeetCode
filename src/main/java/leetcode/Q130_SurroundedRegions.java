package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

 A region is captured by flipping all 'O's into 'X's in that surrounded region.

 For example,
 X X X X
 X O O X
 X X O X
 X O X X
 After running your function, the board should be:

 X X X X
 X X X X
 X X X X
 X O X X
 */

class Point {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Q130_SurroundedRegions {
	int[][] steps = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	// bfs solution
	public void solve(char[][] board) {
		if (board.length == 0)
			return;
		int w = board[0].length;
		int h = board.length;

		Deque<Point> queue = new ArrayDeque();
		for (int i = 0; i < w; i++) {
			if (board[0][i] == 'O') {
				Point p = new Point(i, 0);
				queue.add(p);
			}
			if (board[h - 1][i] == 'O') {
				Point p = new Point(i, h - 1);
				queue.add(p);
			}
		}

		for (int i = 1; i < h - 1; i++) {
			if (board[i][0] == 'O') {
				Point p = new Point(0, i);
				queue.add(p);
			}
			if (board[i][w - 1] == 'O') {
				Point p = new Point(w - 1, i);
				queue.add(p);
			}
		}

		while (!queue.isEmpty()) {
			Point p = queue.poll();
			int x = p.x;
			int y = p.y;
			board[x][y] = 'V';

			for (int i = 0; i < 4; i++) {
				int x1 = x + steps[i][0];
				int y1 = y + steps[i][1];

				if (x1 < 0 || x1 >= w || y1 < 0 || y1 >= h)
					continue;
				if (board[x1][y1] == 'O') {
					Point p1 = new Point(x1, y1);
					queue.add(p1);
				}
			}
		}

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (board[i][j] == 'V')
					board[i][j] = 'O';
				else
					board[i][j] = 'X';
			}
		}
	}

	// dfs will cause java.lang.StackOverflowError for large input
    public void solveDfs(char[][] board) {
        if (board == null || board.length == 0) return;

        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            walkAround(board, i, 0);
        }
        for (int i = 0; i < n; i++) {
            walkAround(board, 0, i);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'V'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void walkAround(char[][] board, int rowIdx, int colIdx) {
        if (rowIdx < 0 || rowIdx == board.length || colIdx < 0 || colIdx == board[0].length) {
            return;
        }
        if (board[rowIdx][colIdx] == 'X' || board[rowIdx][colIdx] == 'V') {
            return;
        }

        board[rowIdx][colIdx] = 'V';
        int[][] steps = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
        for (int i = 0; i < steps.length; i++) {
            int nextRowIdx = rowIdx + steps[i][0];
            int nextColIdx = colIdx + steps[i][1];

            walkAround(board, nextRowIdx, nextColIdx);
        }
    }
}
