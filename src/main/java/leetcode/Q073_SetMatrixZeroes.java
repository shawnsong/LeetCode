package leetcode;

import java.util.Arrays;

/*
 Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

 click to show follow up.
 Follow up:

 Did you use extra space?
 A straight forward solution using O(mn) space is probably a bad idea.
 A simple improvement uses O(m + n) space, but still not the best solution.
 Could you devise a constant space solution?
 */
public class Q073_SetMatrixZeroes {
	public void setZeroes(int[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return;
		
		int[] height = new int[matrix.length];
		int[] width = new int[matrix[0].length];
		
		for (int i = 0; i < height.length; i++) {
			for (int j = 0; j < width.length; j++) {
				if (matrix[i][j] == 0) {
					height[i] = 1;
					width[j] = 1;
				}
			}
		}
		for(int i = 0; i < height.length; i++) {
			if (height[i] == 1) {
				Arrays.fill(matrix[i], 0);
			}
		}
		for (int i= 0; i < width.length; i++) {
			if (width[i] == 1) {
				for (int j = 0; j < height.length; j++) 
					matrix[j][i] = 0;
			}
		}
	}
}
