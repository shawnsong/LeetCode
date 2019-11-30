package leetcode.knapsack;

/**
 * In the supermarket, there is are different sizes of flour which have different prices,
 * weights and stocks. Given dollar amount n, find the max weights of flour you can buy.
 */
public class MultiKnapsack {

    public int maxWeightsOptimized(int[] prices, int[] weights, int[] amounts, int n) {

        int m = prices.length;

        int[] dp = new int[n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 1; j <= amounts[i]; j++) {
                for (int k = n; k >= prices[i]; k--) {
                    dp[k] = Math.max(dp[k], dp[k - prices[i]] + weights[i]);
                }
            }
        }
        return dp[n];
    }

    public int maxWeights(int[] prices, int[] weights, int[] amounts, int n) {
        int m = prices.length;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i-1][j];
                for (int k = 1; k <= amounts[i - 1]; k++) {
                    if (j >= k * prices[i-1]) {
                        dp[i][j] = Math.max(dp[i][j], dp[i-1][j - k * prices[i-1]] + weights[i-1] * k);
                    }
                }
            }
        }
        return dp[m][n];
    }
}
