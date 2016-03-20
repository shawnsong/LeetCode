package leetcode;

/*
 Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its 
 upper left corner (row1, col1) and lower right corner (row2, col2).

 Example:
 Given matrix = [
 [3, 0, 1, 4, 2],
 [5, 6, 3, 2, 1],
 [1, 2, 0, 1, 5],
 [4, 1, 0, 1, 7],
 [1, 0, 3, 0, 5]
 ]

 sumRegion(2, 1, 4, 3) -> 8
 sumRegion(1, 1, 2, 2) -> 11
 sumRegion(1, 2, 2, 4) -> 12
 */
public class Q304_RangeSumQuery2D {

	int[][] dp;

	public Q304_RangeSumQuery2D(int[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return;

		int h = matrix.length;
		int w = matrix[0].length;

		dp = new int[h][w];

		int sum = 0;
		for (int i = 0; i < w; i++) {
			sum += matrix[0][i];
			dp[0][i] = sum;
		}

		sum = 0;
		for (int i = 0; i < h; i++) {
			sum += matrix[i][0];
			dp[i][0] = sum;
		}

		for (int i = 1; i < h; i++) {
			for (int j = 1; j < w; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1]
						+ matrix[i][j];
			}
		}
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		int ret = dp[row2][col2];

		int c1 = col1 < col2 ? col1 : col2;
		int c2 = col1 < col2 ? col2 : col1;

		int r1 = row1 < row2 ? row1 : row2;
		int r2 = row1 < row2 ? row2 : row1;

		if (r1 != 0) {
			ret -= dp[r1 - 1][c2];
		}
		if (c1 != 0) {
			ret -= dp[r2][c1 - 1];
		}

		if (r1 != 0 && c1 != 0)
			ret += dp[r1 - 1][c1 - 1];

		return ret;
	}
}
