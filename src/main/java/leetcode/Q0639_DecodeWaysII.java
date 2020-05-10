package leetcode;

public class Q0639_DecodeWaysII {
  public int numDecodings(String s) {
    if (s == null || s.length() == 0) return 0;
    long[] dp = new long[s.length() + 1];

    long base = 1000000000 + 7;

    dp[0] = 1;
    dp[1] = s.charAt(0) == '*' ? 9: 1;

    for (int i = 2; i <= s.length(); i++) {
      char first = s.charAt(i - 2);
      char second = s.charAt(i - 1);

      // dp[i-1]
      if (second == '*') {
        dp[i] = 9 * dp[i - 1];
      } else if (second > '0'){
        // because '0' itself doesn't decode to anything
        dp[i] = dp[i - 1];
      }

      // consider s.charAt(i-2) and s.charAt(i-1) as a number
      if (first == '*') {
        if (second == '*') {
          // "**" can represent 11 to 26, except 20. So it should be 26-11+1-1=15
          // because '*' represents '1' to '9', not '0'
          dp[i] += 15 * dp[i - 2];
        } else if (second <= '6') {
          // '*' can be 1x or 2x, so 2 different cases
          dp[i] += 2 * dp[i - 2];
        } else {
          // current digit > '6' so * can only be 1
          dp[i] += dp[i - 2];
        }
      } else if (first == '1' || first == '2'){
        if (first == '1') {
          if (second == '*') {
            dp[i] += 9 * dp[i - 2];
          } else {
            dp[i] += dp[i - 2];
          }
        } else {
          if (second == '*') {
            dp[i] += 6 * dp[i - 2];
          } else if (second >= '0' && second <= '6') {
            dp[i] += dp[i - 2];
          }
        }
      }
      dp[i] = dp[i] % base;
    }
    return (int)dp[s.length()];
  }
}
