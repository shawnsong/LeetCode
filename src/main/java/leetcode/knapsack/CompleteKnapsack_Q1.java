package leetcode.knapsack;

import java.util.ArrayList;

/**
 * Given the prices of products and the total money, return the minimum money you can keep after buying the products.
 * Each product has infinite stocks so can be bought many times.
 */
public class CompleteKnapsack_Q1 {

    public int minTips(int[] prices, int k) {
        int m = prices.length;

        ArrayList<Integer> newPrices = new ArrayList<>();
        for (int price : prices) {
            int count = k / price;
            for (int i = 0; i < count; i++) {
                newPrices.add(price);
            }
        }
        boolean[][] dp = new boolean[newPrices.size() + 1][k + 1];
        for (int i = 0; i <= newPrices.size(); i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= newPrices.size(); i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = dp[i-1][j];
                if (j >= newPrices.get(i - 1)) {
                    dp[i][j] = dp[i][j] || dp[i-1][j - newPrices.get(i-1)];
                }
            }
        }
        int i = k;
        for (; i >= 0; i--) {
            if (dp[newPrices.size()][i]) {
                break;
            }
        }
        return k - i;
    }

    public int minTipsOptimized(int[] prices, int k) {
        boolean[] dp = new boolean[k + 1];
        dp[0] = true;

        for (int i = 0; i < prices.length; i++) {
            for (int j = 1; j <= k; j++) {
                if (j >= prices[i]) {
                    dp[j] = dp[j] || dp[j - prices[i]];
                }
            }
        }
        int i = k;
        for (; i >= 0; i--) {
            if (dp[i]) {
                break;
            }
        }
        return k - i;
    }
}
