package leetcode;

/*
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000

Answer: 1

Example 2:

11000
11000
00100
00011

Answer: 3
 */
public class Q200_NumberOfIslands {
	public int numIslands(char[][] grid) {
		int count = 0;
		if (grid == null || grid.length == 0)
			return 0;
		int m = grid.length;
		int n = grid[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '1') {
					count++;
					walkAround(grid, i, j);
				}
			}
		}
		
		return count;
	}
	
	private void walkAround(char[][] grid, int i, int j) {
		int[][] steps = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)
			return;
		if (grid[i][j] == '0' || grid[i][j] == '3')
			return;
		
		grid[i][j] = '3';
		for (int ii = 0; ii < steps.length; ii++) {
			int x = i + steps[ii][0];
			int y = j + steps[ii][1];
			
			walkAround(grid, x, y);
		}
	}
}
