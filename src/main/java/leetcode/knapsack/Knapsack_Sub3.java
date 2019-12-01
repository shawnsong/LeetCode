package leetcode.knapsack;

import java.util.Arrays;

public class Knapsack_Sub3 {

    public double maxProbability(int n, int[] prices, double[] probability) {
        // write your code here
        int m = prices.length;

        double[] dp = new double[n + 1];
        Arrays.fill(dp, 1);
        for (int i = 1; i <= m; i++) {
            for (int j = n; j >= prices[i-1]; j--) {
                dp[j] = Math.min(dp[j], dp[j - prices[i - 1]] * (1 - probability[i - 1]));
            }
        }
        return 1 - dp[n];
    }
}
