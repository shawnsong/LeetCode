package leetcode;

/*
Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4]. 
 */
public class Q034_SearchForARange {
	public int[] searchRange(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1; 
		
		int[] res = {-1, -1};
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] < target) {
				low = mid + 1;
			} else if (nums[mid] > target) {
				high = mid - 1;
			} else {
				res[0] = mid;
				high = mid - 1;
			}
		}
		
		low = 0;
		high = nums.length - 1; 
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] < target) {
				low = mid + 1;
			} else if (nums[mid] > target) {
				high = mid - 1;
			} else {
				res[1] = mid;
				low = mid + 1;
			}
		}
		
		return res;
	}
}
