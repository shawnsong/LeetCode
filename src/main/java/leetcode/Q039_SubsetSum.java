package leetcode;

import java.util.Arrays;

/**
 * This is an extension of Q39. Combination Sum. Here we try to do two things:
 * 1. find if there exists a subset that can sum to a given value
 * 2. find how many subsets there are that can sum to the given value
 */
public class Q039_SubsetSum {
    public boolean hasSubset(int[] nums, int target) {
        boolean[][] dp = new boolean[nums.length][target + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }
        Arrays.sort(nums);
        if (target < nums[0]) {
            return false;
        }
        dp[0][nums[0]] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                if (nums[i] > j) {
                    dp[i][j] = dp[i -1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[nums.length - 1][target];
    }

    public int numberOfSubsets(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            for (int j = Math.min(sum, target); j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[target];
    }
}
