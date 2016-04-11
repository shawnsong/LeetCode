package leetcode;

import java.util.PriorityQueue;

/*
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, 
not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note:
You may assume k is always valid, 1 ¡Ü k ¡Ü array's length.
 */
public class Q215_KthLargestElementInAnArray {
	public int findKthLargest(int[] nums, int k) {
		if (k >= nums.length || k < 0)
			return -1;
		
		PriorityQueue<Integer> heap = new PriorityQueue();
		
		int i =0;
		for (; i < k; i++) {
			heap.add(nums[i]);
		}
		for (; i < nums.length; i++) {
			if (nums[i] > heap.peek()) {
				heap.poll();
				heap.add(nums[i]);
			}
		}
		
		return heap.peek();
	}
}
