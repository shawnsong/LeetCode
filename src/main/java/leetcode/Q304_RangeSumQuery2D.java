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

    int[][] sum;

    public Q304_RangeSumQuery2D(int[][] matrix) {

        int m = matrix.length, n = matrix[0].length;
        if (m == 0 || n == 0) {
            sum = new int[0][0];
            return;
        }
        sum = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum[i+1][j+1] = sum[i] [j+1] + sum[i+1][j] + - sum[i][j] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row2 + 1][col2 + 1] - sum[row2 +1][col1] - sum[row1][col2 + 1] + sum[row1][col1];
    }
}
