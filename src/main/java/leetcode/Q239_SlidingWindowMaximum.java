package leetcode;

import java.util.LinkedList;

public class Q239_SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        LinkedList<Integer> queue = new LinkedList<>();
        int resIdx = 0;
        int[] res = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && queue.peek() < i - k + 1) {
                queue.poll();
            }
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }
            queue.offer(i);

            if (i >= k-1) {
                res[resIdx] = nums[queue.peek()];
                resIdx++;
            }
        }
        return res;
    }
}
