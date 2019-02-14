package leetcode;

/*
 Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

 Integers in each row are sorted in ascending from left to right.
 Integers in each column are sorted in ascending from top to bottom.
 For example,

 Consider the following matrix:

 [
 [1,   4,  7, 11, 15],
 [2,   5,  8, 12, 19],
 [3,   6,  9, 16, 22],
 [10, 13, 14, 17, 24],
 [18, 21, 23, 26, 30]
 ]
 Given target = 5, return true.

 Given target = 20, return false.
 */
public class Q240_SearchA2DMatrixII {
	// start from top right
	public boolean searchMatrix(int[][] matrix, int target) {
		int n = matrix[0].length;
		return search(matrix, target, 0, n - 1);
	}

	private boolean search(int[][] matrix, int t, int m, int n) {
		if (m >= matrix.length || n < 0)
			return false;
		if (matrix[m][n] == t)
			return true;

		if (matrix[m][n] < t) {
			return search(matrix, t, m + 1, n);
		} else {
			return search(matrix, t, m, n - 1);
		}
	}
}
