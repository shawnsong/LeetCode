package leetcode;

import java.util.PriorityQueue;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Example 1:
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 *
 * Example 2:
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
public class Q215_KthLargestElementInAnArray {
	public int findKthLargest(int[] nums, int k) {
		if (k > nums.length || k < 0)
			return -1;
		int left = 0, right = nums.length - 1;
		k = nums.length - k;
		while (true) {
			int index = partition(nums, left, right);
			if (index < k) {
				left = index + 1;
			} else if (index > k) {
				right = index - 1;
			} else {
				break;
			}
		}
		return nums[k];
	}


	private int partition(int[] nums, int left, int right) {
		int pivot = nums[left];
		int i = left + 1, j = right;
		while (i < j) {
			while(nums[i] < pivot) {
				i++;
			}
			while(nums[j] > pivot) {
				j--;
			}
			if (i >= j) {
				break;
			}
			swap(nums, i, j);
			i++;
			j--;
		}
		swap(nums, left, j);
		return j;
	}

	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
