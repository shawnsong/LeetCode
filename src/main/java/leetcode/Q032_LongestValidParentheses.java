package leetcode;

import java.util.Stack;

public class Q032_LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);      // invalid index of '('
            } else {
                if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                    stack.pop();    // valid now, pop
                } else {
                    stack.push(i);  // invalid index of ')'
                }
            }
        }

        if (stack.isEmpty()) {
            return s.length();
        }

        int maxLen = 0;
        int index = s.length() -1;
        while (!stack.isEmpty()) {
            int len = index - stack.peek() - 1;
            maxLen = Math.max(len, maxLen);
            index = stack.pop();
        }
        maxLen = Math.max(maxLen, index);
        return maxLen;
    }

    public int longestValidParentheses2(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }

        int[] dp = new int[s.length() + 1];
        int openCount = 0;
        int longest = 0;
        for (int i = 1; i <= s.length(); i++) {
            if (s.charAt(i - 1) == '(') {
                openCount++;
            } else {
                if (openCount > 0) {
                    openCount--;
                    dp[i] = dp[i - 1] + 2;
                    dp[i] += dp[i -  dp[i]];
                    longest = Math.max(longest, dp[i]);
                }
            }
        }
        return longest;
    }
}
