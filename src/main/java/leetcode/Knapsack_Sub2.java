package leetcode;

/**
 * n items of different weights. find all possible ways to fill a bag of size k
 */
public class Knapsack_Sub2 {
    public int numWays(int[] weights, int k) {
        int count = 0;
        int m = weights.length;
        boolean[][] dp = new boolean[m+1][k+1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = dp[i-1][j];
                if (j >= weights[i - 1]) {
                    dp[i][j] = dp[i][j] || dp[i-1][j - weights[i - 1]];
                }
                if (j == k && dp[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }
}
