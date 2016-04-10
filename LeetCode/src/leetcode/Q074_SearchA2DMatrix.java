package leetcode;

/*
 Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

 Integers in each row are sorted from left to right.
 The first integer of each row is greater than the last integer of the previous row.
 For example,

 Consider the following matrix:

 [
 [1,   3,  5,  7],
 [10, 11, 16, 20],
 [23, 30, 34, 50]
 ]
 Given target = 3, return true.
 */
public class Q074_SearchA2DMatrix {
	public static void main(String[] a) {
		Q074_SearchA2DMatrix o = new Q074_SearchA2DMatrix();
		int[][] m = {{1,   3,  5,  7},  {10, 11, 16, 20},  {23, 30, 34, 50}};
		o.searchMatrix(m, 11);
	}
	public boolean searchMatrix(int[][] matrix, int target) {
		int rowIdx = binarySearch(matrix, target, 0, 2);
		if (matrix[rowIdx][0] == target)
			return true;
		// search row
		int colIdx = binarySearch(matrix, target, rowIdx, 1);
		if (matrix[rowIdx][colIdx] == target)
			return true;
		else
			return false;
		
	}
	
	public int binarySearch(int[][] m, int t, int idx, int flag) {
		int[] arr = null;
		if (flag == 1) {
			// search row
			arr = m[idx];
		} else {
			// search column
			arr = new int[m.length];
			for (int i = 0; i < m.length; i++)
				arr[i] = m[i][idx];
		}
		
		int low = 0;
		int high = arr.length - 1;
		
		while (low <= high) {
			int mid = low + (high - low) /2;
			if (arr[mid] == t)
				return mid;
			else if (arr[mid] < t) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return (low + high) /2;
	}
}
