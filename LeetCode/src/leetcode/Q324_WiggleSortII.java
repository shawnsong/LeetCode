package leetcode;

import java.util.PriorityQueue;

/*
 Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

 Example:
 (1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6]. 
 (2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].

 Note:
 You may assume all input has valid answer.

 Follow Up:
 Can you do it in O(n) time and/or in-place with O(1) extra space?


 */
public class Q324_WiggleSortII {
	public void wiggleSort(int[] nums) {
		if (nums == null || nums.length <= 1)
			return;
		int len = nums.length;
		int[] sorted = new int[len];
		for (int i = 0; i < len; i++)
			sorted[i] = nums[i];

		int median = findMedian(nums);
		int smallIdx = 0;
		int midIdx = 0;
		int largeIdx = len - 1;

		// partition by median
		while (midIdx <= largeIdx) {
			if (sorted[midIdx] < median) {
				swap(sorted, smallIdx, midIdx);
				smallIdx++;
				midIdx++;
			} else if (sorted[midIdx] > median) {
				swap(sorted, largeIdx, midIdx);
				largeIdx--;
			} else {
				midIdx++;
			}
		}

		for (int i = 0; i <= (len - 1) / 2; i++) {
			if (i * 2 < len)
				nums[i * 2] = sorted[(len - 1) / 2 - i];
		}
		for (int i = 0; i <= (len - 1) / 2; i++) {
			if (i * 2 + 1 < len)
				nums[i * 2 + 1] = sorted[len - 1 - i];
		}
	}

	private void swap(int[] nums, int i, int j) {
		// TODO Auto-generated method stub
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	private int findMedian(int[] nums) {
		PriorityQueue<Integer> minHeap = new PriorityQueue();
		int i = 0;
		int k = nums.length / 2;
		for (i = 0; i < k; i++)
			minHeap.add(nums[i]);
		for (; i < nums.length; i++) {
			if (nums[i] > minHeap.peek()) {
				minHeap.poll();
				minHeap.add(nums[i]);
			}
		}
		return minHeap.peek();
	}
}
