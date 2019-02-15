package leetcode;

import java.util.LinkedList;
import java.util.List;

/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]

You should return [1,2,3,6,9,8,7,4,5]. 
 */
public class Q054_SpiralMatrix {

	public List<Integer> spiralOrder(int[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return new LinkedList();

		int height = matrix.length;
		int width = matrix[0].length;

		int left = 0;
		int right = width - 1;
		int top = 0;
		int bottom = height - 1;

		int i;

		List<Integer> res = new LinkedList();
		while (left <= right && top <= bottom) {
			i = left;
			// left to right
			while (i <= right) {
				res.add(matrix[top][i]);
				i++;
			}
			top++;

			// up to down
			i = top;
			while (i <= bottom) {
				res.add(matrix[i][right]);
				i++;
			}
			right--;

			// right to left
			i = right;
			if (top > bottom)
				break;
			while (i >= left) {
				res.add(matrix[bottom][i]);
				i--;
			}
			bottom--;

			// down to up
			if (left > right)
				break;
			i = bottom;
			while (i >= top) {
				res.add(matrix[i][left]);
				i--;
			}
			left++;
		}

		return res;
	}
}
