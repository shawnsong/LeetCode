package leetcode;

import java.util.Arrays;

/*
Follow up for N-Queens problem.

Now, instead outputting board configurations, return the total number of distinct solutions.
 */
public class Q052_NQueensII {
	
	
	private int count = 0;
	
	public static void main(String[] ar) {
		Q052_NQueensII o = new Q052_NQueensII();
		System.out.println(o.totalNQueens(4));
	}
	
	public int totalNQueens(int n) {
		if (n == 1)
			return 1;
		if (n < 4)
			return 0;

		int[] colIdxArr = new int[n];
		Arrays.fill(colIdxArr, -1);
		solve(colIdxArr, 0);
		return count;
	}
	
	private void solve(int[] colIdxArr, int rowIdx) {
		if (rowIdx == colIdxArr.length) {
			count++;
			return;
		}
		
		for (int i = 0; i < colIdxArr.length; i++) {
			if (canPut(colIdxArr, rowIdx, i)) {
				colIdxArr[rowIdx] = i;
				solve(colIdxArr, rowIdx + 1);
				colIdxArr[rowIdx] = -1;
			}
		}
	}
	
	private boolean canPut(int[] colIdxArr, int rowIdx, int colIdx) {
		for (int i = 0; i < rowIdx; i++) {
			if (colIdxArr[i] == colIdx)
				return false;
			
			if (Math.abs(colIdxArr[i] - colIdx) == Math.abs(i - rowIdx))
				return false;
		}
		return true;
	}
}
