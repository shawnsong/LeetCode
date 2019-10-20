package leetcode;

import java.util.Arrays;

/**
 * Find max sum sub-matrix in a given matrix
 */
public class Q363_Sub2 {
    public int findMaxSumSubMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] sums = new int[m];
        int max = 0;
        for (int left = 0; left < n; left++) {
            Arrays.fill(sums, 0);
            for (int j = left; j < n; j++) {
                for (int i = 0; i < m; i++) {
                    sums[i] += matrix[i][j];
                }
                int maxSubArr = findMaxSumSubArray(sums);
                max = Math.max(maxSubArr, max);
            }
        }
        return max;
    }

    int findMaxSumSubArray(int[] nums) {
        int max = nums[0];
        int maxSoFar = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int cur = Math.max(maxSoFar + nums[i], nums[i]);
            max = Math.max(cur, max);
            maxSoFar = cur;
        }
        return max;
    }
}
