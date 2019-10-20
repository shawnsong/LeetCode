package leetcode;

/**
 * Given strings S and T, find the minimum (contiguous) substring W of S, so that T is a subsequence of W.
 *
 * If there is no such window in S that covers all characters in T, return the empty string "". If there are multiple
 * such minimum-length windows, return the one with the left-most starting index.
 */
public class Q727_MinimumWindowSubsequence {
    public String minWindow(String s, String t) {
        int m = t.length(), n = s.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i + 1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(j - 1) == t.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        int len = s.length() + 1;
        int start = 0;
        for (int i = 1; i <= n; i++) {
            if (dp[m][i] != 0) {
                if (i - dp[m][i] < len) {
                    len = i - dp[m][i];
                    start = dp[m][i] - 1;
                }
            }
        }
        return len == s.length() + 1 ? "" : s.substring(start, start + len + 1);
    }

    public String minWindow2(String s, String t) {
        if (s == t) {
            return s;
        }
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }
        int right = 0;
        String res = "";
        while (right < s.length()) {
            int tPos = 0;
            while (right < s.length()) {
                if (t.charAt(tPos) == s.charAt(right)) {
                    tPos++;
                    if (tPos == t.length()) {
                        break;
                    }
                }
                right++;
            }
            if (right == s.length() && tPos < t.length()) {
                return res;
            }
            int left = right;
            tPos = t.length() - 1;
            while (left >= 0) {
                if (s.charAt(left) == t.charAt(tPos)) {
                    tPos--;
                }
                if (tPos < 0) {
                    break;
                }
                left--;
            }
            int len = right - left + 1;
            if (res.length() == 0 || len < res.length()) {
                res = s.substring(left, right + 1);
            }
            right = left + 1;
        }
        return res;
    }
}
