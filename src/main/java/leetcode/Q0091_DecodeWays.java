package leetcode;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 *
 * Example 1:
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 */
public class Q0091_DecodeWays {
  public int numDecodings(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }

    if (s.charAt(0) == '0') {
      return 0;
    }

    int[] dp = new int[s.length() + 1];
    dp[0] = 1;
    dp[1] = 1;
    for (int i = 2; i <= s.length(); i++) {
      int oneDigit = s.charAt(i - 1) - '0';
      int twoDigits = Integer.parseInt(s.substring(i-2, i));
      if (oneDigit > 0) {
        dp[i] += dp[i - 1];
      }
      if (twoDigits > 9 && twoDigits <= 26) {
        dp[i] += dp[i - 2];
      }
    }
    return dp[s.length()];
  }
}
