package leetcode;

public class Q010_RegularExpressionMatching {

    public boolean isMatch(String s, String p) {

        if (s == null || p == null) {
            return false;
        }

        int strLen = s.length();
        int patternLen = p.length();

        boolean[][] dp = new boolean[strLen + 1][patternLen + 1];
        dp[0][0] = true;

        for (int i = 0; i < patternLen; i++) {
            if (p.charAt(i) == '*' && i > 0) {
                dp[0][i + 1] = dp[0][i - 1];
            }
        }

        for (int i = 0; i < strLen; i++) {
            for (int j = 0; j < patternLen; j++) {
                if (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.') {
                    dp[i + 1][j + 1] = dp[i][j];
                } else if (p.charAt(j) == '*') {
                    // * counts as empty
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    } else  {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1] || dp[i][j + 1] || dp[i + 1][j];
                    }
                }
            }
        }

        return dp[s.length()][p.length()];
    }

}
