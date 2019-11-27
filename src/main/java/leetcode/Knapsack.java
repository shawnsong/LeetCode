package leetcode;

public class Knapsack {

    public int maxValue(int[] weights, int[] vals, int maxWeight) {
        int m = weights.length;
        int n = maxWeight;

        // dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - w[i - 1]] + v[i - 1])
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (j < weights[i - 1]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i-1][j - weights[i - 1]] + vals[i - 1]);
                }
            }
        }
        return dp[m][n];
    }

    int maxVal = 0;
    private int maxValueDfs(int[] weights, int[] vals, int maxWeight) {
        dfs(weights, vals, 0, 0, 0, maxWeight);
        return maxVal;
    }

    private void dfs(int[] weights, int[] vals, int startIdx, int prevW, int prevV, int maxW) {
        if (prevW > maxW) {
            return;
        } else {
            maxVal = Math.max(maxVal, prevV);
        }

        for (int i = startIdx; i < weights.length; i++) {
            dfs(weights, vals, i + 1, prevW + weights[i], prevV + vals[i], maxW);
        }
    }
}
