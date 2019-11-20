package leetcode;

/**
 * Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums.
 * You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins.
 * Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.
 *
 * Find the maximum coins you can collect by bursting the balloons wisely.
 *
 * You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
 * 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 */
public class Q312_BurstBalloons {

    public int maxCoins(int[] nums) {
        int[] arr = new int[nums.length + 2];
        int idx = 1;
        for (int num : nums) {
            if (num > 0) {
                arr[idx] = num;
                idx++;
            }
        }

        arr[0] = arr[idx] = 1;
        int n = idx + 1;

        int[][] dp = new int[n][n];
        for (int len = 2; len < n; len++) {
            for (int left = 0; left < n - len; left++) {
                int right = left + len;
                for (int i = left + 1; i < right; i++) {
                    dp[left][right] = Math.max(
                        dp[left][right],
                        arr[left] * arr[i] * arr[right] + dp[left][i] + dp[i][right]
                    );
                }
            }
        }
        return dp[0][n - 1];
    }
}
