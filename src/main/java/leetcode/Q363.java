package leetcode;

import java.util.Arrays;
import java.util.TreeSet;

public class Q363 {

    public int maxSumSubmatrix(int[][] matrix, int k) {
        int row = matrix.length, col = matrix[0].length;
        int res = Integer.MIN_VALUE;
        int[] sums = new int[row];
        for (int left = 0; left < col; left++) {
            Arrays.fill(sums, 0);
            for (int right = left; right < col; right++) {
                for (int i = 0; i < row; i++) {
                    sums[i] += matrix[i][right];
                }
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                int curSum = 0;

                for (int sum : sums) {
                    curSum += sum;
                    // because sum of sub-matrix no larger than k
                    // sum(j) - sum(i) <= k, sum(j) is curSum, we want to find sum(i)
                    // so sum(i) >= sum(j) - k, but sum(i) is small enough
                    Integer num = set.ceiling(curSum - k);
                    if (num != null) {
                        res = Math.max(curSum - num, res);
                    }
                    set.add(curSum);
                }
            }
        }
        return res;
    }
}
