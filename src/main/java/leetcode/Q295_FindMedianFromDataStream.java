package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value.
 * So the median is the mean of the two middle value.
 *
 * For example,
 * [2,3,4], the median is 3
 *
 * [2,3], the median is (2 + 3) / 2 = 2.5
 *
 * Design a data structure that supports the following two operations:
 *
 * void addNum(int num) - Add a integer number from the data stream to the data structure.
 * double findMedian() - Return the median of all elements so far.
 */
public class Q295_FindMedianFromDataStream {

    PriorityQueue<Long> maxHeap, minHeap;

    /** initialize your data structure here. */
    public Q295_FindMedianFromDataStream() {
        maxHeap = new PriorityQueue<>((a, b) -> {
            if (a > b) return -1;
            else if (a < b) return 1;
            else return 0;
        });
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (maxHeap.isEmpty() || num < maxHeap.size()) {
            maxHeap.add((long)num);
        } else {
            minHeap.add((long)num);
        }
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        } else if (maxHeap.size() - minHeap.size() > 1) {
            minHeap.add(maxHeap.poll());
        }
    }

    public double findMedian() {
        if ((maxHeap.size() + minHeap.size()) % 2 == 1) {
            return (double)maxHeap.peek();
        } else {
            return (double) (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }
}
