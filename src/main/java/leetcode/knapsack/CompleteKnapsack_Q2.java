package leetcode.knapsack;

/**
 * n items of different weights. Find all possible ways to fill a bag of size k. Each item can be used multiple times.
 */
public class CompleteKnapsack_Q2 {

    public int numWays(int[] weights, int k) {
        int m = weights.length;

        int[][] dp = new int[m + 1][k + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= weights[i - 1]) {
                    dp[i][j] += dp[i][j - weights[i - 1]];
                }
            }
        }
        return dp[m][k];
    }

    public int numWays2(int[] weights, int k) {
        int[] dp = new int[k + 1];
        dp[0] = 1;
        for (int i = 0; i < weights.length; i++) {
            for (int j = 1; j <= k; j++) {
                if (j >= weights[i]) {
                    dp[j] += dp[j - weights[i]];
                }
            }
        }
        return dp[k];
    }
}
