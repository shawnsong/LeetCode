package leetcode;

/*
 Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right 
 which minimizes the sum of all numbers along its path.

 Note: You can only move either down or right at any point in time.
 */
public class Q064_MinimumPathSum {
	public int minPathSum(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;

		int[][] dp = new int[m][n];
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += grid[0][i];
			dp[0][i] = sum;
		}
		sum = 0;
		for (int i = 0; i < m; i++) {
			sum += grid[i][0];
			dp[i][0] = sum;
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
			}
		}

		return dp[m - 1][n - 1];
	}
}
