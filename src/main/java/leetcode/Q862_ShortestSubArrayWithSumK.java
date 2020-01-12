package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.TreeMap;

public class Q862_ShortestSubArrayWithSumK {
    public int shortestSubarray(int[] a, int k) {
        int n = a.length;
        int[] sums = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
            sums[i] = sum;
        }
        int res = n + 1;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, -1);
        for (int i = 0; i < n; i++) {
            int tmp = sums[i] - k;
            Integer prevSum = map.floorKey(tmp);
            while (prevSum != null && sums[i] - map.get(prevSum) >= k) {
                res = Math.min(res, i - map.get(prevSum));
                prevSum = map.floorKey(prevSum - 1);
            }
            map.put(sums[i], i);
        }
        return res == n + 1 ? -1 : res;
    }

    public int shortestSubArrayMonotonicQueue(int[] a, int k) {
        int n = a.length;
        int[] sums = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
            sums[i] = sum;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        int res = a.length + 1;
        for (int i = 0; i < sums.length; i++) {
            if (sums[i] >= k) {
                res = Math.min(res, i + 1);
            }
            while (deque.size() > 0 && sums[i] <= deque.peekLast()) {
                deque.pollLast();
            }
            while (deque.size() > 0 && sums[i] - sums[deque.peekFirst()] >= k) {
                res = Math.min(res, i - deque.pollFirst());
            }
            deque.add(i);
        }
        while (deque.size() > 0) {
            int idx = deque.pollFirst();
            if (sums[idx] >= k) {
                res = Math.min(res, idx + 1);
            }
        }
        return res == a.length + 1 ? -1 : res;
    }
}
