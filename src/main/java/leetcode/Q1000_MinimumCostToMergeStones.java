package leetcode;

public class Q1000_MinimumCostToMergeStones {

    //
    public int mergeStonesTwo(int[] stones) {
        if (stones == null || stones.length == 0) {
            return 0;
        }

        int len = stones.length;
        int[][] dp = new int[len + 1][len + 1];

        int[] prefixSum = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            prefixSum[i] = prefixSum[i - 1] + stones[i - 1];
        }

        for (int i = 1; i <= len; i++) {
            dp[i][i] = 0;
        }

        // dp[i][j] = sum[i ~ j] + min(dp[i][k] + dp[k+1][j]) (i <= k < j)
        for (int l = 2; l <= len; l++) {
            for (int i = 1; i <= len - l + 1; i++) {
                int j = i + l - 1;
                dp[i][j] = Integer.MAX_VALUE;
                int sum = prefixSum[j] - prefixSum[i - 1];
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + sum);
                }
            }
        }
        return dp[1][len];
    }
}
