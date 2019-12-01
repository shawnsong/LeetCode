package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a matrix, and a target, return the number of non-empty submatrices that sum to target.
 * A submatrix x1, y1, x2, y2 is the set of all cells matrix[x][y] with x1 <= x <= x2 and y1 <= y <= y2.
 * Two submatrices (x1, y1, x2, y2) and (x1', y1', x2', y2') are different if they have some coordinate that is different:
 * for example, if x1 != x1'.
 */
public class Q1074_NumberOfSubmatricesThatSumToTarget {
    public int numSubMatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int[] sums = new int[m];
        int count = 0;
        for (int left = 0; left < n; left++) {
            Arrays.fill(sums, 0);
            for (int right = left; right < n; right++) {
                for (int i = 0; i < m; i++) {
                    sums[i] += matrix[i][right];
                }
                count += numOfSubArraySumToK(sums, target);
            }
        }
        return count;
    }

    int numOfSubArraySumToK(int[] nums, int k) {
        int sum = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            sum += num;
            int remain = sum - k;
            if (map.containsKey(remain)) {
                count += map.get(remain);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
