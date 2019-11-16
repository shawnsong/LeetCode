package leetcode;

import java.util.Arrays;

public class Q265_PaintHousesII {
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        int k = costs[0].length;
        if (k == 1) {
            return costs[0][0];
        }
        int[] prevs = new int[k];
        int[] mins = new int[k];
        for (int[] cost : costs) {
            Arrays.fill(mins, Integer.MAX_VALUE);
            int min = prevs[0];
            for (int i = 1; i < k; i++) {
                mins[i] = min;
                min = Math.min(min, prevs[i]);
            }
            min = prevs[k - 1];
            for (int i = k - 2; i >= 0; i--) {
                mins[i] = Math.min(mins[i], min);
                min = Math.min(min, prevs[i]);
            }
            for (int i = 0; i < k; i++) {
                prevs[i] = mins[i] + cost[i];
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            min = Math.min(min, prevs[i]);
        }
        return min;
    }

    public int minCostII2(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;

        int m = costs.length, k = costs[0].length;
        int minIdx1 = -1;
        int minIdx2 = -1;

        for (int i = 0; i < m; i++) {
            int last1 = minIdx1;
            int last2 = minIdx2;
            minIdx1 = -1;
            minIdx2 = -1;
            for (int j = 0; j < k; j++) {
                if (j != last1) {
                    costs[i][j] += last1 == -1 ? 0 : costs[i-1][last1];
                } else {
                    costs[i][j] += last2 == -1 ? 0 : costs[i-1][last2];
                }

                if (minIdx1 == -1 || costs[i][j] < costs[i][minIdx1]) {
                    minIdx2 = minIdx1;
                    minIdx1 = j;
                } else if (minIdx2 == -1 || costs[i][j] < costs[i][minIdx2]) {
                    minIdx2 = j;
                }
            }
        }
        return costs[m-1][minIdx1];
    }
}
