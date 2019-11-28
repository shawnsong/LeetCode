package leetcode.knapsack;

/**
 * Lintcode 92: find the max sum of elements from an array that the sum is no larger than m
 * i.e. find the maximum weight you can put in a knapsack of size m
 */
public class Knapsack_Sub1 {

    public int maxKnapsack(int[] weights, int k) {
        int m = weights.length;
        boolean[][] dp = new boolean[m + 1][k + 1];
        dp[0][0] = true;

        for (int i = 0; i < m; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = dp[i-1][j];
                if(j >= weights[i - 1]) {
                    dp[i][j] = dp[i-1][j - weights[i-1]];
                }
            }
        }
        for (int i = k; i >= 0; i--) {
            if (dp[m][i]) {
                return i;
            }
        }
        return 0;
    }
}
