package leetcode;

/*
 Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" 
cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
 */
public class Q079_WordSearch {

	public boolean exist(char[][] board, String word) {

		int m = board.length;
		int n = board[0].length;
		// note the cache only need to be created once outside the loop
		boolean[][] visited = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == word.charAt(0)) {
					boolean found = findPath(board, i, j, word, 0, visited);
					if (found)
						return true;
				}
			}
		}
		return false;
	}

	// do not use word.substring, instead use word.charAt(idx)
	// this can increase efficiency a lot!!
	private boolean findPath(char[][] board, int x, int y, String word, int idx, boolean[][] visited) {
		if (word.length() == idx)
			return true;
		if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
			return false;
		}
		if (board[x][y] != word.charAt(0))
			return false;
		if (visited[x][y])
			return false;
		int[][] steps = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

		visited[x][y] = true;
		for (int i = 0; i < steps.length; i++) {
			int x1 = x + steps[i][0];
			int y1 = y + steps[i][1];

			boolean found = findPath(board, x1, y1, word, idx + 1, visited);
			if (found)
				return true;
		}
		visited[x][y] = false;
		return false;
	}
}
