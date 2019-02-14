package leetcode;

/*
 Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

 For example,
 Given n = 3,

 You should return the following matrix:
 [
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
 ]
 */
public class Q059_SpiralMatrixII {

	public int[][] generateMatrix(int n) {
		if (n == 1) {
			int[][] res = new int[1][1];
			res[0][0] = 1;
			return res;
		}
		
		int layer = (n+1) / 2;
		int count = 1;
		
		int[][] res = new int[n][n];
		int size = n - 1;
		int offset = 0;
		for (int i = 0; i < layer; i++) {
			if (size == 0) {
				res[offset][offset] = n * n;
				break;
			}
			int direction = 0;
			for (int r = 0; r < 4; r++) {
				for (int j = 0; j < size; j++) {
					if (direction == 0) { // top
						res[offset][offset + j] = count;
					} else if (direction == 1) { // right
						res[offset + j][n - offset - 1] = count;
					} else if (direction == 2) { // bottom
						res[n - 1 - offset][n - 1 - offset - j] = count;
					} else {
						res[n - offset - 1 - j][offset] = count;
					}
					count++;
				}
				direction++;
			}
			size = size - 2;
			offset++;
		}
		return res;
	}
}
