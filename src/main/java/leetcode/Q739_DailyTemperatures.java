package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a list of daily temperatures T, return a list such that, for each day in the input,
 * tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible,
 * put 0 instead.
 *
 * For example, given the list of temperatures
 *                   T = [73, 74, 75, 71, 69, 72, 76, 73],
 * your output should be [1,  1,  4,  2,  1,  1,  0,  0].

 */
public class Q739_DailyTemperatures {
    public int[] dailyTemperatures(int[] temps) {
        int n = temps.length;
        int[] res = new int[n];

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (deque.size() > 0 && temps[i] > temps[deque.peekLast()]) {
                int prev = deque.pollLast();
                res[prev] = i - prev;
            }
            deque.addLast(i);
        }
        return res;
    }
}
