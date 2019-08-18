package leetcode;

/**
 * Alice plays the following game, loosely based on the card game "21".
 *
 * Alice starts with 0 points, and draws numbers while she has less than K points.
 * During each draw, she gains an integer number of points randomly from the range [1, W], where W is an integer.
 * Each draw is independent and the outcomes have equal probabilities.
 *
 * Alice stops drawing numbers when she gets K or more points.  What is the probability that she has N or less points?
 */
public class Q837_New21Game {
    public double new21Game(int n, int k, int w) {
        if (k <= 0 || n >= w + k) {
            return 1;
        }

        // n = 27, k = 21, w = 10;
        // p27 = p26 + p25 + p24 ... + p21
        double dp[] = new double[n + 1];
        dp[0] = 1;
        double res = 0;
        double sum = 1;

        for (int i = 1; i <= n; i++) {
            dp[i] = sum / w;
            if (i < k) {
                sum += dp[i];
            } else {
                // i >= k, res (i.e. p27) = p21 + p22 + ... + p27
                res += dp[i];
            }
            if (i >= w) {
                sum -= dp[i - w];
            }
        }
        return res;
    }
}
