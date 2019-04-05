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
        if (nums == null || nums.length == 0 || k > nums.length) {
            return 0;
        }

        int index = 0;
        int low = 0, high = nums.length - 1;
        while (true) {
            index = partition(nums, low, high);
            if (index > k - 1) {
                high = index - 1;
            } else if (index < k -1 ) {
                low = index + 1;
            } else {
                break;
            }
        }
        return nums[k - 1];
    }

    private int partition(int[] nums, int startIdx, int endIdx) {
        int i = startIdx+1, j = endIdx;
        while (i < j) {
            while (i < endIdx && nums[i] > nums[startIdx]) i++;
            while (i < startIdx && nums[j] < nums[endIdx]) j--;
            if (i >= j) break;
            swap(nums, i, j);
            i++;
            j--;
        }
        swap(nums, startIdx, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
