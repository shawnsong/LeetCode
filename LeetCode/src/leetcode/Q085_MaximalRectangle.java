package leetcode;

import java.util.Stack;

/*
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones
 *  and return its area.
 */

public class Q085_MaximalRectangle {
	public int maximalRectangle(char[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return 0;
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] dp = new int[m][n];
		
		for (int i = 0; i < n; i++)
			dp[0][i] = matrix[0][i] == '1' ? 1 : 0;
		
		int maxArea = 0;
		for (int i = 1; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(matrix[i][j] == '1') {
					dp[i][j] = dp[i - 1][j] + 1;
				}
			}
		}
		
		for (int i = 0; i < m; i++) {
			maxArea = Math.max(maxArea, maxHeightOfRow(dp[i]));
		}
		return maxArea;
	}
	
	private static int maxHeightOfRow(int[] heights) {
		Stack<Integer> idxStack = new Stack();
		int maxArea = 0;
		int i;
		for (i = 0; i < heights.length; i++) {
			if (idxStack.isEmpty() || heights[idxStack.peek()] < heights[i])
				idxStack.push(i);
			else {
				while (!idxStack.isEmpty() && heights[idxStack.peek()] > heights[i]) {
					int height = heights[idxStack.pop()];
					
					if (idxStack.isEmpty())
						maxArea = Math.max(maxArea, height * i);
					else {
						maxArea = Math.max(maxArea, height * (i - 1-idxStack.peek()));
					}
				}
				idxStack.push(i);
			}
		}

		while (!idxStack.isEmpty()) {
			int height = heights[idxStack.pop()];
			if (idxStack.isEmpty())
				maxArea = Math.max(maxArea, height * i);
			else
				maxArea = Math.max(maxArea, height * (i - 1-idxStack.peek()));
		}
		
		return maxArea;
	}
}
