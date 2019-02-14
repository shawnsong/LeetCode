package leetcode;

/*
 Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.

 For example, given the following matrix:

 1 0 1 0 0
 1 0 1 1 1
 1 1 1 1 1
 1 0 0 1 0
 Return 4.

 */
public class Q221_MaximalSquare {

	public int maximalSquare(char[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return 0;
		int height = matrix.length;
		int width = matrix[0].length;
		
		int[][] dp = new int[height][width];
		int max = 0;
		for (int i = 0; i < height; i++) {
			dp[i][0] = matrix[i][0] - '0';
			if (matrix[i][0] == '1')
				max = 1;
		}
		for (int i = 0; i < width; i++) {
			dp[0][i] = matrix[0][i] - '0';
			if (matrix[0][i] == '1')
				max = 1;
		}
		
		
		for (int i = 1; i< height; i++) {
			for (int j = 1; j < width; j++) {
				if (matrix[i][j] == '1') {
					dp[i][j] = getMin(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1;
					max = Math.max(dp[i][j], max);
				}
			}
		}
		return max * max;
	}
	
	private int getMin(int a, int b, int c) {
		return Math.min(a, Math.min(b, c));
	}
}
