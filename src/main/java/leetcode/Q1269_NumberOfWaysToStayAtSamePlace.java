package leetcode;

public class Q1269_NumberOfWaysToStayAtSamePlace {
    public int numWays(int steps, int arrLen) {
        if (arrLen == 1) {
            return 1;
        }
        int[][] dp = new int[steps][steps + 1];
        dp[0][0] = 1;
        dp[0][1] = 1;
        int base = 1000000000 + 7;
        for (int i = 1; i < steps; i++) {
            for (int j = 0; j < Math.min(steps, arrLen); j++) {
                if (j == 0) {
                    dp[i][j] = (dp[i-1][j] % base + dp[i-1][j + 1] % base) % base;
                } else if (j == steps - 1) {
                    dp[i][j] = (dp[i-1][j] % base + dp[i-1][j - 1] % base) % base;
                } else {
                    dp[i][j] = ((dp[i-1][j] + dp[i-1][j - 1]) % base + dp[i-1][j+1]) % base;
                }
            }
        }
        return dp[steps-1][0];
    }
}
