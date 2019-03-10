package leetcode;

import java.util.PriorityQueue;


public class Q215_KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return -1;
        }

        k = nums.length - k;
        int left = 0, right = nums.length - 1;
        while (true) {
            int index = partition(nums, left, right);
            if (index > k) {
                right = index - 1;
            } else if (index < k) {
                left = index + 1;
            } else {
                break;
            }
        }
        return nums[k];
    }

    int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int i = left + 1, j = right;
        while (true) {
            while (i < right && nums[i] < pivot) {
                i++;
            }
            while (j > left && nums[j] > pivot) {
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
