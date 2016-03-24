package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

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
		if (board == null || board.length == 0)
			return;
		int height = board.length;
		int width = board[0].length;
		for (int i = 0; i < width; i++) {
			if (board[0][i] == 'O') {
				walkAround(board, 0, i);
			}
			if (board[height - 1][i] == 'O') {
				walkAround(board, height - 1, i);
			}
		}

		for (int i = 0; i < height; i++) {
			if (board[i][0] == 'O')
				walkAround(board, i, 0);
			if (board[i][width - 1] == 'O')
				walkAround(board, i, width - 1);
		}
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (board[i][j] == 'V')
					board[i][j] = 'O';
				else 
					board[i][j] = 'X';
			}
		}
	}

	private void walkAround(char[][] board, int y, int x) {
		if (x < 0 || x >= board[0].length || y < 0 || y >= board.length)
			return;

		if (board[y][x] != 'O')
			return;
		board[y][x] = 'V';

		// walks around
		for (int i = 0; i < 4; i++) {
			int x1 = x + steps[i][0];
			int y1 = y + steps[i][1];

			walkAround(board, y1, x1);
		}
	}
}
