package leetcode;

import java.util.Arrays;

/**
 * Given a string s. In one step you can insert any character at any index of the string.
 * Return the minimum number of steps to make s palindrome.
 *
 * Input: s = "mbadm"
 * Output: 2
 * Explanation: String can be "mbdadbm" or "mdbabdm".
 *
 * Input: s = "leetcode"
 * Output: 5
 * Explanation: Inserting 5 characters the string becomes "leetcodocteel".
 */
public class Q1312_MinimumInsertionToMakePalindrome {

  /**
   * Bottom up
   */
  public int minInsertions(String s) {
    int n = s.length();
    int[][] dp = new int[n][n];

    for (int len = 2; len <= s.length(); len++) {
      for (int left = 0; left + len - 1 < n; left++) {
        int right = left + len - 1;
        if (s.charAt(left) == s.charAt(right)) {
          dp[left][right] = dp[left + 1][right - 1];
        } else {
          dp[left][right] = 1 + Math.min(dp[left][right - 1], dp[left + 1][right]);
        }
      }
    }
    return dp[0][n - 1];
  }

  /**
   * Top-down memorization
   */
  public int minInsertions1(String s) {
    int n = s.length();
    int[][] dp = new int[n][n];
    for (int i = 0; i < n; i++) {
      Arrays.fill(dp[i], -1);
    }

    return  minInserts(s.toCharArray(), 0, s.length() - 1, dp);
  }

  int minInserts(char[] arr, int left, int right, int[][] dp) {
    if (left == right) {
      dp[left][right] = 0;
      return 0;
    }
    if (left + 1 == right) {
      dp[left][right] = arr[left] == arr[right] ? 0 : 1;
      return dp[left][right];
    }

    if (dp[left][right] != -1) {
      return dp[left][right];
    }

    int res;
    if (arr[left] == arr[right]) {
      res = minInserts(arr, left + 1, right - 1, dp);
    } else {
      res = 1 + Math.min(minInserts(arr, left, right - 1, dp), minInserts(arr, left + 1, right, dp));
    }
    dp[left][right] = res;
    return res;
  }
}
