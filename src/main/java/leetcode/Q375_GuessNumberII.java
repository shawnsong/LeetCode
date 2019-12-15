package leetcode;

/**
 * We are playing the Guess Game. The game is as follows:
 * I pick a number from 1 to n. You have to guess which number I picked.
 * Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.
 * However, when you guess a particular number x, and you guess wrong, you pay $x. You win the game when you guess the number I picked.
 *
 * Example:
 *
 * n = 10, I pick 8.
 * First round:  You guess 5, I tell you that it's higher. You pay $5.
 * Second round: You guess 7, I tell you that it's higher. You pay $7.
 * Third round:  You guess 9, I tell you that it's lower. You pay $9.
 * Game over. 8 is the number I picked.
 *
 * You end up paying $5 + $7 + $9 = $21.
 */
public class Q375_GuessNumberII {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        return find(dp, 1, n);
    }

    int find(int[][] dp, int start, int end) {
        if (start >= end) {
            return 0;
        }
        if (dp[start][end] != 0) {
            return dp[start][end];
        }

        int res = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            int tmp = Math.max(find(dp, start, i - 1), find(dp, i + 1, end)) + i;
            res = Math.min(res, tmp);
        }
        dp[start][end] = res;
        return res;
    }
}
