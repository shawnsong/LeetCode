package leetcode.knapsack;

import java.util.ArrayList;

public class CompleteKnapsack {

    /**
     * We convert complete knapsack to 0-1 knapsack and when we do the state transition, we traverse backwardly
     * so we can use a 1 dimension array
     */
    public int maxValue(int[] weights, int[] values, int k) {
        ArrayList<Integer> newWeights = new ArrayList<>();
        ArrayList<Integer> newValues = new ArrayList<>();
        int n = 0;
        for (int i = 0; i < weights.length; i++) {
            int count = k / weights[i];
            n += count;
            for (int j = 0; j < count; j++) {
                newWeights.add(weights[i]);
                newValues.add(values[i]);
            }
        }

        int[] dp = new int[k + 1];
        for(int i = 0; i < n; i++) {
            for (int j = k; j >= newWeights.get(i); j--) {
                dp[j] = Math.max(dp[j], dp[j - newWeights.get(i)] + newValues.get(i));
            }
        }
        return dp[k];
    }

    /**
     * The above method can be optimized to O(V * m) if we traverse from left to right
     * the reason is because 1 item can be used unlimited times.
     * In 0/1 knapsack, if we traverse from left to right, dp[j - weight[i-1]] will cause 1 item being used
     * multiple times, but this is not a problem for complete knapsack.
     */
    public int maxValueOptimized(int[] weights, int[] values, int k) {
        int[] dp = new int[k + 1];
        for (int i = 0; i < weights.length; i++) {
            for (int j = 1; j <= k; j++) {
                if (j >= weights[i]) {
                    dp[j] = Math.max(dp[j], dp[j - weights[i]] + values[i]);
                }
            }
        }
        return dp[k];
    }
}
