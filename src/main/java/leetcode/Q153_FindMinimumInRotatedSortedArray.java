package leetcode;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 *
 *  (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 *
 *  Find the minimum element.
 *
 *  You may assume no duplicate exists in the array.
 */
public class Q153_FindMinimumInRotatedSortedArray {

	public int findMin(int[] nums) {
		if (nums.length == 1) 
			return nums[0];
		int left = 0;
		int right = nums.length - 1;

		// 1, 2
		while (left < right) {
			if (nums[left] < nums[right])
				break;

			int mid = left + (right - left) / 2;
			if (nums[mid] >= nums[left]) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
        return nums[left];
	}
}