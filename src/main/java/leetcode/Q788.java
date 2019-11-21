package leetcode;

/**
 * X is a good number if after rotating each digit individually by 180 degrees, we get a valid number that is different from X.
 * Each digit must be rotated - we cannot choose to leave it alone.
 * A number is valid if each digit remains a digit after rotation. 0, 1, and 8 rotate to themselves; 2 and 5 rotate to each other;
 * 6 and 9 rotate to each other, and the rest of the numbers do not rotate to any other number and become invalid.
 * Now given a positive number N, how many numbers X from 1 to N are good?
 *
 * Example:
 * Input: 10
 * Output: 4
 * Explanation:
 * There are four good numbers in the range [1, 10] : 2, 5, 6, 9.
 * Note that 1 and 10 are not good numbers, since they remain unchanged after rotating.
 */
public class Q788 {
    public int rotatedDigits(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (isValid(i)) {
                count++;
            }
        }
        return count;
    }
    boolean isValid(int num) {
        boolean valid = false;
        while (num > 0) {
            int d = num % 10;
            if (d == 4 || d == 7 || d == 3) {
                return false;
            }
            if (d == 2 || d == 5 || d == 6 || d == 9) {
                valid = true;
            }
            num = num / 10;
        }
        return valid;
    }

    public int rotate(int n) {
        int[] dp = new int[n + 1];
        int count = 0;
        // i has to start from 0
        for (int i = 0; i <= n; i++) {
            if (i < 10) {
                if (i == 2 || i == 5 || i == 6 || i == 9) {
                    dp[i] = 2;
                    count++;
                } else if (i == 0 || i == 1 || i == 8) {
                    dp[i] = 1;
                }
            } else {
                int a = i % 10;
                int b = i / 10;
                if (dp[a] == 1 && dp[b] == 1) {
                    dp[i] = 1;
                } else if (dp[a] >= 1 && dp[b] >= 1) {
                    dp[i] = 2;
                    count++;
                }
            }
        }
        return count;
    }
}
