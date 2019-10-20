package leetcode;

public class Q440_KthSmallestLexicographicalOrder {
    public int findKthNumber(int n, int k) {
        int cur = 1;
        k = k - 1;
        while (k > 0) {
            int steps = calStepsToRight(n, cur, cur + 1);
            if (steps <= k) {
                cur += 1;
                k -= steps;
            } else {
                // move to it's left most child, i.e. pre-order traversal
                cur = cur * 10;
                k = k - 1;
            }
        }
        return cur;
    }
    //use long in case of overflow
    public int calStepsToRight(int n, long n1, long n2) {
        int steps = 0;
        while (n1 < n) {
            steps += Math.min(n + 1, n2) - n1;
            n1 = n1 * 10;
            n2 = n2 * 10;
        }
        return steps;
    }
}
