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
        maxHeap = new PriorityQueue<>();
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        maxHeap.add((long)num);
        minHeap.add(-maxHeap.poll());
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(-minHeap.poll());
        }
    }

    public double findMedian() {
        if ( (maxHeap.size() + minHeap.size()) % 2 == 0) {
            return (double)(maxHeap.peek() - minHeap.peek()) / 2.0;
        }
        return maxHeap.peek();
    }
}
